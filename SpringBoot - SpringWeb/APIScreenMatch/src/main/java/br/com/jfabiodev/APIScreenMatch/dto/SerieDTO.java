package br.com.jfabiodev.APIScreenMatch.dto;

import br.com.jfabiodev.APIScreenMatch.enums.Categoria;

public record SerieDTO(Long id,
                       String titulo,
                       Integer totalTemporadas,
                       Double avaliacao,
                       Categoria genero,
                       String atores,
                       String poster,
                       String sinopse
                       ){}
