package br.com.jfabiodev.MusicGem.model;

import jakarta.persistence.*;

@Entity
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String genero;
    @ManyToOne
    private Artista artista;

    private Musica(){}

    public Musica(String nome, String genero, Artista artista) {
        this.nome = nome;
        this.genero = genero;
        this.artista = artista;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    @Override
    public String toString() {
        return "Nome='" + nome + ", Artista='" + artista.getNome();
    }
}
