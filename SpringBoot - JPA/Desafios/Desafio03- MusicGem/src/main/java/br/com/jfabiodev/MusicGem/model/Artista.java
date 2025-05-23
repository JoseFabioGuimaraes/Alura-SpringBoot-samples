package br.com.jfabiodev.MusicGem.model;

import br.com.jfabiodev.MusicGem.enums.TipoArtista;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Artistas")
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String nome;
    @Enumerated(EnumType.STRING)
    private TipoArtista tipoArtista;
    @OneToMany (mappedBy = "artista", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Musica> musicas = new ArrayList<>();

    public Artista(){}

    public Artista(List<Musica> musicas, TipoArtista tipoArtista, String nome) {
        this.musicas = musicas;
        this.tipoArtista = tipoArtista;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TipoArtista getTipoArtista() {
        return tipoArtista;
    }

    public void setTipoArtista(TipoArtista tipoArtista) {
        this.tipoArtista = tipoArtista;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<Musica> musicas) {
        this.musicas = musicas;
    }

    @Override
    public String toString() {
        return "Nome Artista ='" + nome + ", Tipo=" + tipoArtista;
    }
}
