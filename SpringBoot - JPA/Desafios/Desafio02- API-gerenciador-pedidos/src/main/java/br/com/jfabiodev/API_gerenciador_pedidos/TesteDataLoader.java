package br.com.jfabiodev.API_gerenciador_pedidos;

import br.com.jfabiodev.API_gerenciador_pedidos.categoria.model.Categoria;
import br.com.jfabiodev.API_gerenciador_pedidos.categoria.repository.CategoriaRepository;
import br.com.jfabiodev.API_gerenciador_pedidos.pedido.model.Pedido;
import br.com.jfabiodev.API_gerenciador_pedidos.pedido.repository.PedidoRepository;
import br.com.jfabiodev.API_gerenciador_pedidos.produto.model.Produto;
import br.com.jfabiodev.API_gerenciador_pedidos.produto.repository.ProdutoRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class TesteDataLoader {

    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;
    private final PedidoRepository pedidoRepository;

    public TesteDataLoader(ProdutoRepository produtoRepository,
                           CategoriaRepository categoriaRepository,
                           PedidoRepository pedidoRepository) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
        this.pedidoRepository = pedidoRepository;
    }

    public void saveData() {
        Produto produto = new Produto("Computador", 5000.00);
        Categoria categoria = new Categoria("Roupa");
        Pedido pedido = new Pedido(LocalDate.now());

        produtoRepository.save(produto);
        categoriaRepository.save(categoria);
        pedidoRepository.save(pedido);
    }



}
