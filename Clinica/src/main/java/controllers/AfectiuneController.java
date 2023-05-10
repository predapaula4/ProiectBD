package controllers;

import dtos.AfectiuneDTO;
import entities.Afectiune;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.AfectiuneServices;

@RestController
@RequestMapping(path = "/afectiune")
public class AfectiuneController {

    @Autowired
    private AfectiuneServices afectiuneService;

    @PostMapping()
    public void createAfectiune(@RequestBody AfectiuneDTO afectiuneDTO) {
        afectiuneService.createAfectiune(afectiuneDTO);
    }

    @GetMapping("/{id}")
    public Afectiune getAfectiuneById(@PathVariable Long id) {
        return afectiuneService.getAfectiuneById(id);
    }
}
