package controllers;

import dtos.AparaturaDTO;
import entities.Aparatura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.AparaturaServices;

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