package com.example.clinica.services;

import com.example.clinica.dtos.PacientDTO;
import com.example.clinica.entities.Angajat;
import com.example.clinica.entities.Material;
import com.example.clinica.entities.Pacient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.clinica.repositories.PacientRepository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class PacientServices {

    @Autowired
    private PacientRepository pacientRepository;
    @Autowired
    private PacientDTO pacientDTO;
    public void createPacient(PacientDTO pacientDTO) {
        Pacient pacient = new Pacient();
        pacient.setIdAfectiune(pacientDTO.getIdAfectiune());
        pacient.setIdProgramare(pacientDTO.getIdProgramare());
        pacient.setNume(pacientDTO.getNume());
        pacient.setPrenume(pacientDTO.getPrenume());
        pacient.setVarsta(pacientDTO.getVarsta());

        pacientRepository.save(pacient);
    }

    public Pacient getPacientById(Long id) {
        return pacientRepository.findById(id).orElse(null);
    }
    public List<Pacient> getAllPacients() {
        return pacientRepository.findAll();
    }
    public void deletePacientById(Long id)
    {
        pacientRepository.deleteById(id);
    }

    public Long getPacientIdByNumeAndPrenume(String nume, String prenume) {
        Pacient pacient = pacientRepository.findByNumeAndPrenume(nume, prenume);
        if (pacient != null) {
            return pacient.getIdPacient();
        }
        return null; // sau aruncați o excepție sau gestionați cazul în funcție de nevoile dvs.
    }
    public void updateIdProgramare(String nume, String prenume, Long idProgramare) {
        Pacient pacient = pacientRepository.findByNumeAndPrenume(nume, prenume);
        if (pacient != null) {
            pacient.setIdProgramare(idProgramare);
            pacientRepository.save(pacient);
        }
    }
    public void updatePacient(Long id, String nume, String prenume)
    {
        Optional<Pacient> optionalPacient = pacientRepository.findById(id);
        if (optionalPacient.isPresent()) {
            Pacient pacient = optionalPacient.get();
            pacient.setNume(nume);
            pacient.setPrenume(prenume);
            pacientRepository.save(pacient);
        } else {
            throw new RuntimeException("Material not found with id " + id);
        }
    }
    public List<Pacient> sortPacientsByNume() {
        List<Pacient> pacienti = pacientRepository.findAll();

        // Utilizăm un Comparator pentru a sorta pacienții în funcție de nume
        Comparator<Pacient> comparator = Comparator.comparing(Pacient::getNume);
        Collections.sort(pacienti, comparator);

        return pacienti;
    }
    public List<Pacient> sortPacientsByVarsta() {
        List<Pacient> pacienti = pacientRepository.findAll();

        // Utilizăm un Comparator pentru a sorta pacienții în funcție de vârstă
        Comparator<Pacient> comparator = Comparator.comparing(Pacient::getVarsta);
        Collections.sort(pacienti, comparator);

        return pacienti;
    }
    public List<Pacient> filterPacientByAfectiune(Long idAfectiune) {
        return pacientRepository.findByAfectiuneId(idAfectiune);
    }
}
