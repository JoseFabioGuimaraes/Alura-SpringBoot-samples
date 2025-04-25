package br.com.jfabiodev.API_gerenciador_pedidos.produto.model;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

@Entity

public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String nome;
    @Column(name = "valor")
    private Double preco;

    public Produto(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }


    public Double getPreco() {
        return preco;
    }

}
