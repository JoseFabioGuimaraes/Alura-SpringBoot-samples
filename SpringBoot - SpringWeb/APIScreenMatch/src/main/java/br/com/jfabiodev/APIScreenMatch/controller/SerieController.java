package br.com.jfabiodev.APIScreenMatch.controller;

import br.com.jfabiodev.APIScreenMatch.dto.SerieDTO;
import br.com.jfabiodev.APIScreenMatch.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SerieController {

    @Autowired
    private SerieService service;

    @GetMapping
    public List<SerieDTO> getAllSeries(){
        return service.getAllSeries();
    }

    @GetMapping("/top5")
    public List<SerieDTO> getTop5Series(){
        return service.getTop5Series();
    }

    @GetMapping("/lancamentos")
    public List<SerieDTO> getNews(){
        return service.getNews();
    }

    @GetMapping("/{id}")
    public SerieDTO getSerieById(@PathVariable Long id){
        return service.getSerieById(id);
    }


}
