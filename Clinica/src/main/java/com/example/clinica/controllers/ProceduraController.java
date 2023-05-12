package com.example.clinica.controllers;

import com.example.clinica.dtos.ProceduraDTO;
import com.example.clinica.entities.Procedura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.clinica.services.ProceduraServices;

@RestController
@RequestMapping(path = "/procedura")
public class ProceduraController {

    @Autowired
    private ProceduraServices proceduraService;

    @PostMapping()
    public void createProcedura(@RequestBody ProceduraDTO proceduraDTO) {
        proceduraService.createProcedura(proceduraDTO);
    }

    @GetMapping("/{id}")
    public Procedura getProceduraById(@PathVariable Long id) {
        return proceduraService.getProceduraById(id);
    }
}