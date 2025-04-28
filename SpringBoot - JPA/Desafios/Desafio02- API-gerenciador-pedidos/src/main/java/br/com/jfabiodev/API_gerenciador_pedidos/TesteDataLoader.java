package br.com.jfabiodev.API_gerenciador_pedidos;

import br.com.jfabiodev.API_gerenciador_pedidos.categoria.model.Categoria;
import br.com.jfabiodev.API_gerenciador_pedidos.categoria.repository.CategoriaRepository;
import br.com.jfabiodev.API_gerenciador_pedidos.pedido.model.Pedido;
import br.com.jfabiodev.API_gerenciador_pedidos.pedido.repository.PedidoRepository;
import br.com.jfabiodev.API_gerenciador_pedidos.produto.model.Produto;
import br.com.jfabiodev.API_gerenciador_pedidos.produto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class TesteDataLoader {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public void principal() {
        // Criando categorias
        Categoria categoriaEletronicos = new Categoria("Eletrônicos");
        Categoria categoriaLivros = new Categoria("Livros");

        // Criando produtos e associando às categorias
        Produto produto1 = new Produto("Notebook", 3500.0, categoriaEletronicos);
        Produto produto2 = new Produto("Smartphone", 2500.0, categoriaEletronicos);
        Produto produto3 = new Produto("Livro de Java", 100.0, categoriaLivros);
        Produto produto4 = new Produto("Livro de Spring Boot", 150.0, categoriaLivros);

        // Associando produtos às categorias
        categoriaEletronicos.setProdutos(List.of(produto1, produto2));
        categoriaLivros.setProdutos(List.of(produto3, produto4));

        // Salvando categorias (cascateia produtos automaticamente, se configurado)
        categoriaRepository.saveAll(List.of(categoriaEletronicos, categoriaLivros));

        // Testando a persistência e o relacionamento
        System.out.println("Categorias e seus produtos:");
        categoriaRepository.findAll().forEach(categoria -> {
            System.out.println("Categoria: " + categoria.getNome());
            categoria.getProdutos().forEach(produto ->
                    System.out.println(" - Produto: " + produto.getNome())
            );
        });
    }
}
