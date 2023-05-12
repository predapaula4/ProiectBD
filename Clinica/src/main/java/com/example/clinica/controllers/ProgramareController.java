package com.example.clinica.controllers;

import com.example.clinica.dtos.ProgramareDTO;
import com.example.clinica.entities.Programare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.clinica.services.ProgramareServices;

@RestController
@RequestMapping(path = "/programare")
public class ProgramareController {

    @Autowired
    private ProgramareServices programareService;

    @PostMapping()
    public void createProgramare(@RequestBody ProgramareDTO programareDTO) {
        programareService.createProgramare(programareDTO);
    }

    @GetMapping("/{id}")
    public Programare getProgramareById(@PathVariable Long id) {
        return programareService.getProgramareById(id);
    }
}
