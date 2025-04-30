package br.com.jfabiodev.API_gerenciador_pedidos.pedido.model;

import br.com.jfabiodev.API_gerenciador_pedidos.produto.model.Produto;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "pedido_produto", joinColumns = @JoinColumn(name = "pedido_id"), inverseJoinColumns = @JoinColumn(name = "produto_id"))
    private List<Produto> produtoList;
    @Column(name = "data_pedido")
    private LocalDate data;

    public Pedido(){}

    public Pedido(LocalDate data) {
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public List<Produto> getProdutoList() {
        return produtoList;
    }

    public void setProdutoList(List<Produto> produtoList) {
        this.produtoList = produtoList;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
    public List<Produto> getProdutos() {
        return produtoList;
    }

}
