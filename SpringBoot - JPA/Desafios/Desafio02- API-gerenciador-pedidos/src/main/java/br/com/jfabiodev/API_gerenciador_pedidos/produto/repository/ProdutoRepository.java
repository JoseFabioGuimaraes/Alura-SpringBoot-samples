package br.com.jfabiodev.API_gerenciador_pedidos.produto.repository;

import br.com.jfabiodev.API_gerenciador_pedidos.produto.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long> {
    boolean existsByNome(String nome);
}
