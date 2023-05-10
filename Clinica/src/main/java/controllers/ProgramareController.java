package controllers;

import dtos.ProgramareDTO;
import entities.Programare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.ProgramareServices;

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
