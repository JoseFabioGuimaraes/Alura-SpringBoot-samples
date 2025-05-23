package br.com.jfabiodev.MusicGem.repository;

import br.com.jfabiodev.MusicGem.model.Artista;
import br.com.jfabiodev.MusicGem.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Long>{
    Optional<Artista> findByNomeContainingIgnoreCase(String nome);
}
