package br.com.jfabiodev.API_gerenciador_pedidos.produto.repository;

import br.com.jfabiodev.API_gerenciador_pedidos.produto.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long> {
    boolean existsByNome(String nome);

    List<Produto> findByNome(String nome);
    List<Produto> findByCategoria (String categoriaNome);
    List<Produto> findByPrecoGreaterThan(Double preco);
    List<Produto> findByPrecoLessThan(Double preco);
    List<Produto> findByNomeContainingIgnoreCase(String nome);
    List<Produto> findByCategoriaOrderByPrecoAsc(String categoriaNome);
    List<Produto> findByCategoriaOrderByPrecoDesc(String categoriaNome);
    long countByCategoria(String categoriaNome);
    long countByPrecoGreaterThan(Double preco);
    List<Produto> findByPrecoLessThanOrNomeContaining(Double preco, String nome);
    List<Produto> findTop3ByOrderByPrecoDesc();
    List<Produto> findTop5ByCategoriaOrderByPrecoAsc(String categoria);

}
