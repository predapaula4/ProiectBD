package com.example.clinica.services;

import com.example.clinica.dtos.AfectiuneDTO;
import com.example.clinica.entities.Afectiune;
import com.example.clinica.entities.Angajat;
import com.example.clinica.entities.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.clinica.repositories.AfectiuneRepository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class AfectiuneServices {

    @Autowired
    private AfectiuneRepository afectiuneRepository;

    public void createAfectiune(AfectiuneDTO afectiuneDTO) {
        Afectiune afectiune =new Afectiune();
        afectiune.setDenumire(afectiuneDTO.getDenumire());
        afectiune.setIdProcedura(afectiuneDTO.getIdProcedura());

        afectiuneRepository.save(afectiune);
    }

    public Afectiune getAfectiuneById(Long id) {
        return afectiuneRepository.findById(id).orElse(null);
    }

    public List<Afectiune> gelAllAfections() {
        return afectiuneRepository.findAll();
    }
    public void deleteAfectiuneById(Long id)
    {
        afectiuneRepository.deleteById(id);
    }

    public void updateAfectiune(Long id, String denumire)
    {
        Optional<Afectiune> optionalAfectiune = afectiuneRepository.findById(id);
        if (optionalAfectiune.isPresent()) {
            Afectiune afectiune = optionalAfectiune.get();
            afectiune.setDenumire(denumire);
            afectiuneRepository.save(afectiune);
        } else {
            throw new RuntimeException("Material not found with id " + id);
        }
    }
    public List<Afectiune> sortAfectiuniByDenumire() {
        List<Afectiune> afectiuni = afectiuneRepository.findAll();

        // Utilizăm un Comparator pentru a sorta afectiunile în funcție de denumire
        Comparator<Afectiune> comparator = Comparator.comparing(Afectiune::getDenumire);
        Collections.sort(afectiuni, comparator);

        return afectiuni;
    }
    public List<Afectiune> filterAfectiuneByProcedura(Long idProcedura) {
        return afectiuneRepository.findByProceduraId(idProcedura);
    }
}