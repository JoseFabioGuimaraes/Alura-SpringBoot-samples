package br.com.jfabiodev.APIScreenMatch.controller;

import br.com.jfabiodev.APIScreenMatch.dto.SerieDTO;
import br.com.jfabiodev.APIScreenMatch.model.Serie;
import br.com.jfabiodev.APIScreenMatch.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SerieController {

    @Autowired
    private SerieRepository repository;

    @GetMapping("/serie")
    public List<SerieDTO> obterSeries(){
        return repository.findAll().stream().map(s -> new SerieDTO(s.getId(),s.getTitulo(),s.getTotalTemporadas(),s.getAvaliacao(),
                s.getGenero(),s.getAtores(),s.getPoster(),s.getSinopse())).collect(Collectors.toList());
    }


}
