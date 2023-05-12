package com.example.clinica.controllers;
import com.example.clinica.dtos.AngajatDTO;
import com.example.clinica.entities.Angajat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.clinica.services.AngajatServices;

@RestController
@RequestMapping(path = "/angajat")
public class AngajatController {

    @Autowired
    private AngajatServices angajatService;

    @PostMapping()
    public void createAngajat(@RequestBody AngajatDTO angajatDTO) {
        angajatService.createAngajat(angajatDTO);
    }

    @GetMapping("/{id}")
    public Angajat getAngajatById(@PathVariable Long id) {
        return angajatService.getAngajatById(Math.toIntExact(id));
    }
}
