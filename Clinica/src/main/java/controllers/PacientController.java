package controllers;

import dtos.PacientDTO;
import entities.Pacient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.PacientServices;

@RestController
@RequestMapping(path = "/pacient")
public class PacientController {

    @Autowired
    private PacientServices pacientService;

    @PostMapping()
    public void createPacient(@RequestBody PacientDTO pacientDTO) {
        pacientService.createPacient(pacientDTO);
    }

    @GetMapping("/{id}")
    public Pacient getPacientById(@PathVariable Long id) {
        return pacientService.getPacientById(id);
    }
}