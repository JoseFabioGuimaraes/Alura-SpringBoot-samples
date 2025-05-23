package br.com.jfabiodev.APIScreenMatch.main;

import br.com.jfabiodev.APIScreenMatch.enums.Categoria;
import br.com.jfabiodev.APIScreenMatch.model.DadosSerie;
import br.com.jfabiodev.APIScreenMatch.model.DadosTemporada;
import br.com.jfabiodev.APIScreenMatch.model.Episodio;
import br.com.jfabiodev.APIScreenMatch.model.Serie;
import br.com.jfabiodev.APIScreenMatch.repository.SerieRepository;
import br.com.jfabiodev.APIScreenMatch.service.ConsumoAPI;
import br.com.jfabiodev.APIScreenMatch.service.ConverteDados;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private Scanner leitura = new Scanner(System.in);
    private ConsumoAPI consumo = new ConsumoAPI();
    private ConverteDados conversor = new ConverteDados();
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=f9173cff";
    private List<DadosSerie> dadosSeries = new ArrayList<>();
    private final SerieRepository repository;
    private List<Serie> series = new ArrayList<>();
    private Optional<Serie> serieBusca;

    public Main(SerieRepository repository) {
        this.repository = repository;
    }

    public void exibeMenu() {
        var opcao = -1;

        while (opcao != 0) {
            var menu = """
                    1 - Buscar séries
                    2 - Buscar episódios
                    3 - Listar séries Buscadas
                    4 - Buscar série por titulo
                    5 - Buscar séries por ator
                    6 - Top 5 series por Avaliação
                    7 - Buscar por categorias
                    8 - Buscar por número de temporadas e avaliação
                    9 - Buscar episódio por trecho
                    10 - Buscar top 5 episodios.
                    11 - Buscar episodios por data
                    
                    0 - Sair
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();


            switch (opcao) {
                case 1:
                    buscarSerieWeb();
                    break;
                case 2:
                    buscarEpisodioPorSerie();
                    break;
                case 3:
                    listarSeriesBuscadas();
                    break;
                case 4:
                    buscarSeriePorTitulo();
                    break;
                case 5:
                    buscarSeriePorAtor();
                    break;
                case 6:
                    buscarTop5Series();
                    break;
                case 7:
                    buscarSeriesPorCategoria();
                    break;
                case 8:
                    buscarSeriePorNumeroDeTemporada();
                    break;
                case 9:
                    buscarEpisodioPorTrecho();
                    break;
                case 10:
                    buscarTop5Episodios();
                    break;
                case 11:
                    buscarEpisodioPosData();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }


    private void buscarSerieWeb() {
        DadosSerie dados = getDadosSerie();
        Serie serie = new Serie(dados);
        repository.save(serie);
        System.out.println(dados);
    }

    private DadosSerie getDadosSerie() {
        System.out.println("Digite o nome da série para busca");
        var nomeSerie = leitura.nextLine();
        var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
        return dados;
    }

    private void buscarEpisodioPorSerie() {
        listarSeriesBuscadas();
        System.out.println("Escolha uma série do nosso catálogo");
        var nomeSerie = leitura.nextLine();
        Optional<Serie> serie = repository.findByTituloContainingIgnoreCase(nomeSerie);


        if (serie.isPresent()) {
            var serieEncontrada = serie.get();
            List<DadosTemporada> temporadas = new ArrayList<>();

            for (int i = 1; i <= serieEncontrada.getTotalTemporadas(); i++) {
                var json = consumo.obterDados(ENDERECO + serieEncontrada.getTitulo().replace(" ", "+") + "&season=" + i + API_KEY);
                DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
                temporadas.add(dadosTemporada);
            }
            temporadas.forEach(System.out::println);
            List<Episodio> episodios = temporadas.stream()
                    .flatMap(d -> d.episodios().stream()
                            .map(e -> new Episodio(d.numero(), e)))
                    .collect(Collectors.toList());
            serieEncontrada.setEpisodios(episodios);
            repository.save(serieEncontrada);
        } else {
            System.out.println("NOT FOUND");
        }
    }

    private void listarSeriesBuscadas() {
        series = repository.findAll();
        series.stream()
                .sorted(Comparator.comparing(Serie::getGenero))
                .forEach(System.out::println);
    }

    ;

    private void buscarSeriePorTitulo() {
        System.out.println("Escolha uma série do nosso catálogo");
        var nomeSerie = leitura.nextLine();

        serieBusca = repository.findByTituloContainingIgnoreCase(nomeSerie);
        if (serieBusca.isPresent()) {
            System.out.println("Dados da série: " + serieBusca.get());

        } else {
            System.out.println("Série não encontrada");
        }
    }

    private void buscarSeriePorAtor() {
        System.out.println("Digite o nome do ator: ");
        var nomeAtor = leitura.nextLine();
        System.out.println("Com a avaliação maior ou igual a: ");
        var avaliacao = leitura.nextDouble();
        List<Serie> seriesEncontradas = repository.findByAtoresContainingIgnoreCaseAndAvaliacaoGreaterThanEqual(nomeAtor, avaliacao);
        System.out.printf("Séries que em que %s trabalhou : \n", nomeAtor );
        seriesEncontradas.forEach(s -> System.out.println("Titulo: " + s.getTitulo() + ",Avaliação: " + s.getAvaliacao()));
    }
    private void buscarTop5Series(){
        List<Serie> seriesTop5 = repository.findTop5ByOrderByAvaliacaoDesc();
        System.out.println("Top 5 series por avaliação: ");
        seriesTop5.forEach(s -> System.out.println("Titulo: " + s.getTitulo() + ",Avaliação: " + s.getAvaliacao()));
    }
    private void buscarSeriesPorCategoria(){
        System.out.println("Qual gênero você deseja buscar? ");
        var nomeGenero = leitura.nextLine();
        Categoria categoria = Categoria.fromPortugues(nomeGenero);
        List<Serie> seriesPorCategoria = repository.findByGenero(categoria);
        System.out.printf("Series da categoria %s encontradas:\n ",categoria);
        seriesPorCategoria.forEach(s -> System.out.println("Titulo: " + s.getTitulo() + ", Avaliação: " + s.getAvaliacao()));
    }
    private void buscarSeriePorNumeroDeTemporada(){
        System.out.println("Digite o numero máximo de temporadas: ");
        var numeroTemporadas = leitura.nextInt();
        System.out.println("Agora digite a quantidade a avaliação (maior ou igual a): ");
        var avaliacao = leitura.nextDouble();
        List<Serie> seriesNumeroTemporadasEAvaliacao = repository.seriesPorTemporadaEAvaliacao(numeroTemporadas,avaliacao);
        seriesNumeroTemporadasEAvaliacao.forEach(s -> System.out.println(s.getTitulo() + " Avaliação: " + s.getAvaliacao()));
    }
    private void buscarEpisodioPorTrecho(){
        System.out.println("Digite o nome do episodio: ");
        var nomeEpisodio = leitura.nextLine();
        List<Episodio> episodiosEncontrados = repository.episodiosPorTrecho(nomeEpisodio);
        episodiosEncontrados.forEach(e -> System.out.printf("Série: %s - Temporada: %s - Episódio: %s - Nome: %s\n" ,
                e.getSerie().getTitulo(), e.getTemporada(), e.getNumeroEpisodio(), e.getTitulo()));
    }
    private void buscarTop5Episodios(){
        buscarSeriePorTitulo();
        if(serieBusca.isPresent()){
            Serie serie = serieBusca.get();
            List<Episodio> topEpisodios = repository.topEpisodiosPorSerie(serie);
            topEpisodios.forEach(e -> System.out.printf("Série: %s - Temporada: %s - Episódio: %s - Nome: %s\n" ,
                    e.getSerie().getTitulo(), e.getTemporada(), e.getNumeroEpisodio(), e.getTitulo()));
        }
    }
    private void buscarEpisodioPosData(){
        buscarSeriePorTitulo();
        if(serieBusca.isPresent()){
            Serie serie = serieBusca.get();
            System.out.println("Digite o ano limite de busca: ");
            var anoLimite = leitura.nextInt();
            leitura.nextLine();
            List<Episodio> episodiosAno = repository.episodiosPorSerieEAno(serie, anoLimite);
            episodiosAno.forEach(System.out::println);
        }
    }
}