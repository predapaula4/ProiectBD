package controllers;
import dtos.AngajatDTO;
import entities.Angajat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.AngajatServices;

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
