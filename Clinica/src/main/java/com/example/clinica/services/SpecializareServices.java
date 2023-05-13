package com.example.clinica.services;

import com.example.clinica.dtos.SpecializareDTO;
import com.example.clinica.entities.Material;
import com.example.clinica.entities.Specializare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.clinica.repositories.SpecializareRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SpecializareServices {

    @Autowired
    private SpecializareRepository specializareRepository;

    public void createSpecializare(SpecializareDTO specializareDTO) {
        Specializare specializare = new Specializare();
        specializare.setDenumire(specializareDTO.getDenumire());

        specializareRepository.save(specializare);
    }

    public Specializare getSpecializareById(Long id) {
        return specializareRepository.findById(id).orElse(null);
    }

    public List<Specializare> getAllSpecializares() {
        return specializareRepository.findAll();
    }
    public void deleteSpecializareById(Long id)
    {
        specializareRepository.deleteById(id);
    }

    public void updateSpecializare(Long id, String denumire)
    {
        Optional<Specializare> optionalSpecializare = specializareRepository.findById(id);
        if (optionalSpecializare.isPresent()) {
            Specializare specializare = optionalSpecializare.get();
            specializare.setDenumire(denumire);
            specializareRepository.save(specializare);
        } else {
            throw new RuntimeException("Material not found with id " + id);
        }
    }
}