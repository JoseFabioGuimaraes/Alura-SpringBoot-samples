package br.com.jfabiodev.API_gerenciador_pedidos.pedido.repository;

import br.com.jfabiodev.API_gerenciador_pedidos.pedido.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Long> {
}
