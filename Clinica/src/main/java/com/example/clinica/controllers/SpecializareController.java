package com.example.clinica.controllers;

import com.example.clinica.dtos.SpecializareDTO;
import com.example.clinica.entities.Specializare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.clinica.services.SpecializareServices;

@RestController
@RequestMapping(path = "/specializare")
public class SpecializareController {

    @Autowired
    private SpecializareServices specializareService;

    @PostMapping()
    public void createSpecializare(@RequestBody SpecializareDTO specializareDTO) {
        specializareService.createSpecializare(specializareDTO);
    }

    @GetMapping("/{id}")
    public Specializare getSpecializareById(@PathVariable Long id) {
        return specializareService.getSpecializareById(id);
    }
}