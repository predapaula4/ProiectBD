package com.example.clinica.controllers;

import com.example.clinica.dtos.AparaturaDTO;
import com.example.clinica.entities.Aparatura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.clinica.services.AparaturaServices;

@RestController
@RequestMapping(path = "/aparatura")
public class AparaturaController {

    @Autowired
    private AparaturaServices aparaturaService;

    @PostMapping()
    public void createAparatura(@RequestBody AparaturaDTO aparaturaDTO) {
        aparaturaService.createAparatura(aparaturaDTO);
    }

    @GetMapping("/{id}")
    public Aparatura getAparaturaById(@PathVariable Long id) {
        return aparaturaService.getAparaturaById(id);
    }
}