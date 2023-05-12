package com.example.clinica.services;

import com.example.clinica.dtos.AfectiuneDTO;
import com.example.clinica.entities.Afectiune;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.clinica.repositories.AfectiuneRepository;

import java.util.List;

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
}