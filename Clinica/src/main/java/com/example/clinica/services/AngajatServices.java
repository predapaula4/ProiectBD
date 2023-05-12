package com.example.clinica.services;

import com.example.clinica.dtos.AngajatDTO;
import com.example.clinica.entities.Angajat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.clinica.repositories.AngajatRepository;

import java.util.List;

@Service
public class AngajatServices {
    @Autowired
    private AngajatRepository angajatRepository;
    public void createAngajat(AngajatDTO angajatDTO) {
        Angajat angajat = new Angajat();
        angajat.setIdSpecializare(Math.toIntExact(angajatDTO.getIdSpecializare()));
        angajat.setNume(angajatDTO.getNume());
        angajat.setPrenume(angajatDTO.getPrenume());
        angajat.setSalariu(angajatDTO.getSalariu());

        angajatRepository.save(angajat);
    }
    public Angajat getAngajatById(int id) {
        return angajatRepository.findById((long) id).orElse(null);
    }

    public List<Angajat> getAllAngajats() {
        return angajatRepository.findAll();
    }
}
