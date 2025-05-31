package br.com.jfabiodev.APIScreenMatch.service;

import br.com.jfabiodev.APIScreenMatch.dto.SerieDTO;
import br.com.jfabiodev.APIScreenMatch.model.Serie;
import br.com.jfabiodev.APIScreenMatch.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SerieService {

    @Autowired
    private SerieRepository repository;

    public List<SerieDTO> getAllSeries() {
        return transformData(repository.findAll());
    }
    public List<SerieDTO> getTop5Series(){
        return transformData(repository.findTop5ByOrderByAvaliacaoDesc());
    }

    public List<SerieDTO> getNews(){
        return transformData(repository.top5NewsEpisodios());
    }

    private List<SerieDTO> transformData(List<Serie> serie){
        return serie.stream().map(s -> new SerieDTO(s.getId(),s.getTitulo(),s.getTotalTemporadas(),s.getAvaliacao(),
                s.getGenero(),s.getAtores(),s.getPoster(),s.getSinopse())).collect(Collectors.toList());
    }

    public SerieDTO getSerieById(Long id) {
        Optional<Serie> serie = repository.findById(id);
        if (serie.isPresent()){
            Serie s = serie.get();
            return new SerieDTO(s.getId(),s.getTitulo(),s.getTotalTemporadas(),s.getAvaliacao(), s.getGenero(),s.getAtores(),s.getPoster(),s.getSinopse());
        }else{
            return null;
        }
    }


}
