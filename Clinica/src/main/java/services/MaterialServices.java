package services;

import dtos.MaterialDTO;
import entities.Material;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.MaterialRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialServices {

    @Autowired
    private MaterialRepository materialRepository;

    public void createMaterial(MaterialDTO materialDTO) {
        Material material = new Material();
        BeanUtils.copyProperties(materialDTO, material);
        materialRepository.save(material);
    }

    public Material getMaterialById(Long id) {
        return materialRepository.findById(id).orElse(null);
    }
    public void deleteMaterialById(Long id) {
        materialRepository.deleteById(id);
    }
    public void updateMaterial(Long id, String denumire) {
        Optional<Material> optionalMaterial = materialRepository.findById(id);
        if (optionalMaterial.isPresent()) {
            Material material = optionalMaterial.get();
            material.setDenumire(denumire);
            materialRepository.save(material);
        } else {
            throw new RuntimeException("Material not found with id " + id);
        }
    }
    public List<Material> getAllMaterials() {
        return materialRepository.findAll();
    }
}