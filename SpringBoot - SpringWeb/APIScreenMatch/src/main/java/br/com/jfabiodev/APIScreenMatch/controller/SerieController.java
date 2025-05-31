package br.com.jfabiodev.APIScreenMatch.controller;

import br.com.jfabiodev.APIScreenMatch.dto.EpisodioDTO;
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

    @GetMapping("/{id}/temporadas/todas")
    public List<EpisodioDTO> getAllSeason(@PathVariable Long id){
        return service.getAllSeason(id);
    }

    @GetMapping("/{id}/temporadas/{numero}")
    public List<EpisodioDTO> getEpisodeBySeason(@PathVariable Long id, @PathVariable Long numero){
        return service.getEpisodeBySeason(id, numero);
    }

    @GetMapping("/categoria/{genero}")
    public List<SerieDTO> getSerieByGender(@PathVariable String genero){
        return service.getSerieByGender(genero);
    }

    @GetMapping("/{id}/temporadas/top")
    public List<EpisodioDTO> getTop5Episodes(@PathVariable Long id){
        return service.getTop5Episodes(id);
    }

}
