package br.com.jfabiodev.API_gerenciador_pedidos.fornecedor.repository;

import br.com.jfabiodev.API_gerenciador_pedidos.fornecedor.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor,Long> {
}
