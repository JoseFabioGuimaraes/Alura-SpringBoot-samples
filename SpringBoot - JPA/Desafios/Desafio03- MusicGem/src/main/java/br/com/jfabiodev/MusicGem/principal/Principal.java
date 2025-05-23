package br.com.jfabiodev.MusicGem.principal;

import br.com.jfabiodev.MusicGem.enums.TipoArtista;
import br.com.jfabiodev.MusicGem.model.Artista;
import br.com.jfabiodev.MusicGem.model.Musica;
import br.com.jfabiodev.MusicGem.repository.ArtistaRepository;
import br.com.jfabiodev.MusicGem.repository.MusicaRepository;
import br.com.jfabiodev.MusicGem.service.ConsultaGemini;

import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner scanner = new Scanner(System.in);
    private ArtistaRepository artistaRepository;
    private MusicaRepository musicaRepository;

    public Principal(ArtistaRepository artistaRepository, MusicaRepository musicaRepository) {
        this.artistaRepository = artistaRepository;
        this.musicaRepository = musicaRepository;
    }


    public void exibeMenu(){
        Integer opcao = -1;
        while (opcao != 0){
            var menu = """
                    1 - Cadastrar um artista
                    2 - Cadastrar músicas na playlist
                    3 - Acessar a playlist
                    4 - Buscar músicas por artistas
                    5 - Pesquisar dados sobre um artista
                
                    
                    0 - Sair
                    """;
            System.out.println(menu);
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao){
                case 1:
                    cadastraArtista();
                    break;
                case 2:
                    cadastraMusica();
                    break;
                case 3:
                    acessarPlaylist();
                    break;
                case 4:
                    acessarMusicasArtista();
                    break;
                case 5:
                    pesquisaSobreArtista();
                    break;
                case 0:
                    System.out.println("Fechando o MusicGem... Até logo :)");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }
    public void cadastraArtista(){
        String continuar ="sim";
        while(continuar.equalsIgnoreCase("sim")){
            System.out.println("Digite o nome do Artista: ");
            var nome = scanner.nextLine();
            System.out.println("Digite o tipo do artista (Solo,Dupla,Banda)");
            var tipo = scanner.nextLine();

            try{
                TipoArtista tipoArtista = TipoArtista.fromString(tipo);
                Artista artista = new Artista();
                artista.setNome(nome);
                artista.setTipoArtista(tipoArtista);
                artistaRepository.save(artista);
                System.out.println("Artista Cadastrado com sucesso!");

            } catch (IllegalArgumentException e){
                System.out.println("Error " + e.getMessage());
            }
            System.out.println("Deseja continuar? (SIM/NAO)");
            continuar = scanner.nextLine();

        }
    }
    public void cadastraMusica(){
        System.out.println("Digite o nome da música: ");
        var nomeMusica = scanner.nextLine();
        System.out.println("Digite o gênero: ");
        var genero = scanner.nextLine();
        System.out.println("Digite o nome do Artista");
        var artistaNome = scanner.nextLine();
        try {
            var artistOptional = artistaRepository.findByNomeContainingIgnoreCase(artistaNome);
            if(artistOptional.isPresent()){
                Artista artista = artistOptional.get();
                Musica musica = new Musica(nomeMusica, genero,artista);
                musicaRepository.save(musica);
                System.out.println("Musica adicionada com Sucesso!");
            } else {
                System.out.println("Artista não encontrado! Cadastre primeiro o artista! ");
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e);
        }
    }
    public void acessarPlaylist(){
        List<Musica> musicasPlaylist = musicaRepository.findAll();
        if(musicasPlaylist.isEmpty()){
            System.out.println("A sua playlist está vazia;");
        }else {
            System.out.println("Musicas em sua playlist: ");
            musicasPlaylist.forEach(System.out::println);
        }
    }

    public void acessarMusicasArtista(){
        System.out.println("Digite o nome do Artista que você deseja achar as musicas: ");
        var nomeArtista = scanner.nextLine();
        System.out.println("Acessando playlist do: " + nomeArtista+"...");
        List<Musica> musicasEncontradas = musicaRepository.findAllByArtista_NomeContainingIgnoreCase(nomeArtista);
        if(musicasEncontradas.isEmpty()){
            System.out.println("Esse artista não tem possui nenhuma musica salva");
        } else {
            musicasEncontradas.forEach(m -> System.out.println("Nome da musica: "+ m.getNome() + "-" + m.getArtista().getNome()));
        }

    }
    public void pesquisaSobreArtista(){
        System.out.println("Digite o Artista que deseja procurar: ");
        var nomeArtista = scanner.nextLine();

        try{
            String inf = ConsultaGemini.obterInformacoes(nomeArtista);
            System.out.println(inf);
        }catch (Exception e){
            System.out.println("Error: "+ e.getMessage());
        }

    }
}
