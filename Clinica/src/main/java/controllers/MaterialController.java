package controllers;
import dtos.MaterialDTO;
import entities.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.MaterialServices;

@RestController
@RequestMapping(path = "/material")
public class MaterialController {

    @Autowired
    private MaterialServices materialService;
    @PostMapping()
    public void createMaterial(@RequestBody MaterialDTO materialDTO) {
        materialService.createMaterial(materialDTO);
    }

    @GetMapping("/{id}")
    public Material getMaterialById(@PathVariable Long id) {
        return materialService.getMaterialById(id);
    }
}
