package br.com.jfabiodev.APIScreenMatchFrase.controller;


import br.com.jfabiodev.APIScreenMatchFrase.dto.FraseDTO;
import br.com.jfabiodev.APIScreenMatchFrase.service.FraseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FraseController {

    @Autowired
    private FraseService service;

    @GetMapping("/series/frases")
    public FraseDTO getFrase(){
        return service.getFrase();
    }
}
