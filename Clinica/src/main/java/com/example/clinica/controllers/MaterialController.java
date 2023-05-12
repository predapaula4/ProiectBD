package com.example.clinica.controllers;
import com.example.clinica.dtos.MaterialDTO;
import com.example.clinica.entities.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.clinica.services.MaterialServices;

import java.util.List;

@RestController
@RequestMapping(path = "/material")
public class MaterialController {

    @Autowired
    private MaterialServices materialService;
    @PostMapping()
    public void createMaterial(@RequestBody MaterialDTO materialDTO) {
        materialService.createMaterial(materialDTO);
    }

//    @GetMapping("/{id}")
//    public Material getMaterialById(@PathVariable Long id) {
//        return materialService.getMaterialById(id);
//    }

    @GetMapping()
    public List<Material> getAllMaterials() {
        return materialService.getAllMaterials();
    }

}
