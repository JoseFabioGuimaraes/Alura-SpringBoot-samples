package br.com.jfabiodev.API_gerenciador_pedidos.produto.repository;

import br.com.jfabiodev.API_gerenciador_pedidos.categoria.model.Categoria;
import br.com.jfabiodev.API_gerenciador_pedidos.produto.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

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

    //Desafio2

    @Query("SELECT p FROM Produto p WHERE p.preco > :valorBusca")
    List<Produto> produtoMaisCaroQue(Double valorBusca);

    @Query("SELECT p FROM Produto p ORDER BY p.preco ASC")
    List<Produto> ordenaPrecoCrescente();

    @Query("SELECT p FROM Produto p ORDER BY p.preco DESC")
    List<Produto> ordenaPrecoDecrescente();

    //ESSA CONSULTA DO ILIKE É ESPECIFICA DO POSTGRES E SÓ PODE SER EXCUTADA COM O COMANDO
    // "spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect" ATIVO NO RESOURCE
    @Query("SELECT p FROM Produto p WHERE p.nome ILIKE %:letra%")
    List<Produto> retornaProdutoIniciadosCom (String letra);

    @Query("SELECT AVG(p.preco) FROM Produto p")
    Double mediaValorP();

    @Query("SELECT MAX(p.preco) FROM Produto p WHERE p.categoria.nome = :categoria")
    Double maiorValorEmUmaCategoria(String categoria);

    @Query("SELECT c.nome,COUNT(p) FROM Produto p JOIN p.categoria c GROUP BY c.nome")
    List<Object[]> contaProdutosCategoria();

    @Query("SELECT c.nome, COUNT(p) FROM Produto p JOIN p.categoria c GROUP BY c.nome HAVING COUNT(p) > :quantidade")
    List<Object[]> categoriasComMaisDe(long quantidade);

    @Query("SELECT p FROM Produto p WHERE p.nome = :nome OR p.categoria.nome = :nome")
    List<Produto> produtosPorNomeOuCategoria(String nome);

    @Query(value = "SELECT * FROM Produto ORDER BY preco DESC LIMIT 5", nativeQuery = true)
    List<Produto> produtosMaisCarosNativo();

}
