package br.com.jfabiodev.APIScreenMatch.repository;

import br.com.jfabiodev.APIScreenMatch.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Long> {
    Optional<Serie> findByTituloContainingIgnoreCase(String tituloSerie);
}
