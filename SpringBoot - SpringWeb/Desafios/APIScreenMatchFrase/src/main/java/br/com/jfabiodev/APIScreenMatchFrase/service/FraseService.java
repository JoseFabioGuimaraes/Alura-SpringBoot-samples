package br.com.jfabiodev.APIScreenMatchFrase.service;

import br.com.jfabiodev.APIScreenMatchFrase.dto.FraseDTO;
import br.com.jfabiodev.APIScreenMatchFrase.model.Frase;
import br.com.jfabiodev.APIScreenMatchFrase.repository.FraseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FraseService {

    @Autowired
    private FraseRepository repository;

    public FraseDTO getFrase() {
        Frase frase = repository.getRandomFrase();
        return new FraseDTO(frase.getTitulo(), frase.getFrase(),
                frase.getPersonagem(), frase.getPoster());
    }
}
