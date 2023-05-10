package controllers;

import dtos.SpecializareDTO;
import entities.Specializare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.SpecializareServices;

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