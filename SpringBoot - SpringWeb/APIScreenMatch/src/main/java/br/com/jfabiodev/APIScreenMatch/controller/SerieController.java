package br.com.jfabiodev.APIScreenMatch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SerieController {

    @GetMapping("/serie")
    public String obterSeries(){
        return "Aqui é as séries";
    }


}
