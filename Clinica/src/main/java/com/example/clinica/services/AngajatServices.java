package com.example.clinica.services;

import com.example.clinica.dtos.AngajatDTO;
import com.example.clinica.entities.Angajat;
import com.example.clinica.entities.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.clinica.repositories.AngajatRepository;

import java.util.*;

@Service
public class AngajatServices {
    @Autowired
    private AngajatRepository angajatRepository;
    public void createAngajat(AngajatDTO angajatDTO) {
        Angajat angajat = new Angajat();
        angajat.setIdSpecializare(Long.valueOf(Math.toIntExact(angajatDTO.getIdSpecializare())));
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
    public void deleteAngajatById(Long id)
    {
        angajatRepository.deleteById(id);
    }
    public void updateAngajat(Long id, String nume, String prenume)
    {
        Optional<Angajat> optionalAngajat = angajatRepository.findById(id);
        if (optionalAngajat.isPresent()) {
            Angajat angajat = optionalAngajat.get();
            angajat.setNume(nume);
            angajat.setPrenume(prenume);
            angajatRepository.save(angajat);
        } else {
            throw new RuntimeException("Material not found with id " + id);
        }
    }
    public List<Angajat> sortAngajatiByNume() {
        List<Angajat> angajati = angajatRepository.findAll();

        Comparator<Angajat> comparator = Comparator.comparing(Angajat::getNume);
        Collections.sort(angajati, comparator);

        return angajati;
    }
    public List<Angajat> sortAngajatiBySalariu() {
        List<Angajat> angajati = angajatRepository.findAll();

        Comparator<Angajat> comparator = Comparator.comparing(Angajat::getSalariu);
        Collections.sort(angajati, comparator);

        return angajati;
    }

}
