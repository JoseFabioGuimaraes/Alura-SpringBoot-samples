package br.com.jfabiodev.API_gerenciador_pedidos.fornecedor.model;

import br.com.jfabiodev.API_gerenciador_pedidos.produto.model.Produto;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @OneToMany(mappedBy = "fornecedor")
    private List<Produto> produtos;

    public Fornecedor(){}

    public Fornecedor(String nome){
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
