package com.example.clinica.services;

import com.example.clinica.dtos.ProgramareDTO;
import com.example.clinica.entities.Programare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.clinica.repositories.ProgramareRepository;

import java.util.List;

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
}