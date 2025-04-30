package br.com.jfabiodev.API_gerenciador_pedidos;

import br.com.jfabiodev.API_gerenciador_pedidos.categoria.model.Categoria;
import br.com.jfabiodev.API_gerenciador_pedidos.categoria.repository.CategoriaRepository;
import br.com.jfabiodev.API_gerenciador_pedidos.fornecedor.model.Fornecedor;
import br.com.jfabiodev.API_gerenciador_pedidos.fornecedor.repository.FornecedorRepository;
import br.com.jfabiodev.API_gerenciador_pedidos.pedido.model.Pedido;
import br.com.jfabiodev.API_gerenciador_pedidos.pedido.repository.PedidoRepository;
import br.com.jfabiodev.API_gerenciador_pedidos.produto.model.Produto;
import br.com.jfabiodev.API_gerenciador_pedidos.produto.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
public class TesteDataLoader {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Transactional
    public void principal() {
        // Criando categorias
        Categoria categoriaEletronicos = new Categoria("Eletrônicos");
        Categoria categoriaLivros = new Categoria("Livros");
        categoriaRepository.saveAll(Arrays.asList(categoriaEletronicos, categoriaLivros));

        // Criando fornecedores
        Fornecedor fornecedorTech = new Fornecedor("Tech Supplier");
        Fornecedor fornecedorLivros = new Fornecedor("Livraria Global");
        fornecedorRepository.saveAll(Arrays.asList(fornecedorTech, fornecedorLivros));

        // Criando produtos com validação
        Produto produto1 = new Produto("Notebook", 3500.0, categoriaEletronicos);
        Produto produto2 = new Produto("Smartphone", 2500.0, categoriaEletronicos);
        Produto produto3 = new Produto("Livro de Java", 100.0, categoriaLivros);
        produto1.setFornecedor(fornecedorTech);
        produto2.setFornecedor(fornecedorTech);
        produto3.setFornecedor(fornecedorLivros);

        List<Produto> produtos = Arrays.asList(produto1, produto2, produto3);
        for (Produto produto : produtos) {
            if (!produtoRepository.existsByNome(produto.getNome())) {
                produtoRepository.save(produto);
            } else {
                System.out.println("Produto com o nome já existe: " + produto.getNome());
            }
        }

        // Criando pedidos e associando produtos
        Pedido pedido1 = new Pedido(LocalDate.now());
        pedido1.setProdutoList(Arrays.asList(produto1, produto3));
        Pedido pedido2 = new Pedido(LocalDate.now().minusDays(1));
        pedido2.setProdutoList(Arrays.asList(produto2));
        pedidoRepository.saveAll(Arrays.asList(pedido1, pedido2));

        // Testando consultas e verificando os relacionamentos
        System.out.println("Produtos na categoria Eletrônicos:");
        categoriaRepository.findById(402L).ifPresent(categoria ->
                categoria.getProdutos().forEach(produto ->
                        System.out.println(" - " + produto.getNome())
                )
        );

        System.out.println("\nPedidos e seus produtos:");
        pedidoRepository.findAll().forEach(pedido -> {
            System.out.println("Pedido " + pedido.getId() + ":");
            pedido.getProdutos().forEach(produto ->
                    System.out.println(" - " + produto.getNome())
            );
        });

        System.out.println("\nProdutos e seus fornecedores:");
        produtoRepository.findAll().forEach(produto ->
                System.out.println("Produto: " + produto.getNome() +
                        ", Fornecedor: " + produto.getFornecedor().getNome())
        );
    }
}