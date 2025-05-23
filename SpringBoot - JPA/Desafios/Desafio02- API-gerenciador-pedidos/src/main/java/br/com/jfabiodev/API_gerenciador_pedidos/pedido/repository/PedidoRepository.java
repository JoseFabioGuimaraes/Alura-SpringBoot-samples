package br.com.jfabiodev.API_gerenciador_pedidos.pedido.repository;

import br.com.jfabiodev.API_gerenciador_pedidos.pedido.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Long> {

    //List<Pedido> findByDataEntregaIsNull(); //TODO: criar esse atributo
    //List<Pedido> findByDataEntregaIsNotNull();
    List<Pedido> findByDataPedidoAfter (LocalDate data);
    List<Pedido> findByDataPedidoBefore (LocalDate data);
    List<Pedido> findByDataPedidoBetween (LocalDate dataInicial, LocalDate dataFinal);

    //DESAFIO 2:
    @Query("SELECT p FROM Pedido p WHERE p.data BETWEEN :dataInicio AND :dataFinal")
    List<Pedido> retornaPedidosEntreDatas(LocalDate dataInicio, LocalDate dataFinal);

}
