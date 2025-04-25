package br.com.jfabiodev.API_gerenciador_pedidos.pedido.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "data_pedido")
    private LocalDate data;

    public Pedido(LocalDate data) {
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }
}
