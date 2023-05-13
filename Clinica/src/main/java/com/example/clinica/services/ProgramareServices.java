package com.example.clinica.services;

import com.example.clinica.dtos.ProgramareDTO;
import com.example.clinica.entities.Material;
import com.example.clinica.entities.Programare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.clinica.repositories.ProgramareRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProgramareServices {

    @Autowired
    private ProgramareRepository programareRepository;

    public void createProgramare(ProgramareDTO programareDTO) {
        Programare programare = new Programare();
        programare.setIdPacient(programareDTO.getIdPacient());
        programare.setIdAngajat(programareDTO.getIdAngajat());
        programare.setDataConsultatie(programareDTO.getDataConsultatie());
        programare.setOraConsultatiei(programareDTO.getOraConsultatiei());

        programareRepository.save(programare);
    }

    public Programare getProgramareById(Long id) {
        return programareRepository.findById(id).orElse(null);
    }
    public List<Programare> getAllProgramare() {
        return programareRepository.findAll();
    }
    public void deleteProgramareById(Long id)
    {
        programareRepository.deleteById(id);
    }
    public void updateProgramare(Long id, LocalDate data, LocalTime ora)
    {
        Optional<Programare> optionalProgramare = programareRepository.findById(id);
        if (optionalProgramare.isPresent()) {
            Programare programare = optionalProgramare.get();
            programare.setDataConsultatie(data);
            programare.setOraConsultatiei(ora);
            programareRepository.save(programare);
        } else {
            throw new RuntimeException("Material not found with id " + id);
        }
    }
}