package br.com.jfabiodev.API_gerenciador_pedidos.categoria.repository;

import br.com.jfabiodev.API_gerenciador_pedidos.categoria.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
