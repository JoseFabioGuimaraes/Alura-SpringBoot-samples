package br.com.jfabiodev.MusicGem.repository;

import br.com.jfabiodev.MusicGem.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, Long> {
    List<Musica> findAll();
    List<Musica> findAllByArtista_NomeContainingIgnoreCase(String nomeArtista);
}
