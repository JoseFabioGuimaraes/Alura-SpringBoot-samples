package br.com.jfabiodev.APIScreenMatchFrase.repository;

import br.com.jfabiodev.APIScreenMatchFrase.model.Frase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FraseRepository extends JpaRepository <Frase, Long>{
    @Query(value = "SELECT * FROM frases ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    Frase getRandomFrase();
}
