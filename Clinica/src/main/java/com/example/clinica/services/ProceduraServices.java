package com.example.clinica.services;

import com.example.clinica.dtos.ProceduraDTO;
import com.example.clinica.entities.Material;
import com.example.clinica.entities.Pacient;
import com.example.clinica.entities.Procedura;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.clinica.repositories.ProceduraRepository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class ProceduraServices {

    @Autowired
    private ProceduraRepository proceduraRepository;

    public void createProcedura(ProceduraDTO proceduraDTO) {
        Procedura procedura = new Procedura();
        BeanUtils.copyProperties(proceduraDTO, procedura);
        proceduraRepository.save(procedura);
    }

    public Procedura getProceduraById(Long id) {
        return proceduraRepository.findById(id).orElse(null);
    }

    public List<Procedura> getAllProceduras() {
        return proceduraRepository.findAll();
    }
    public void deleteProceduraById(Long id)
    {
        proceduraRepository.deleteById(id);
    }
    public void updateProcedura(Long id, String denumire)
    {
        Optional<Procedura> optionalProcedura = proceduraRepository.findById(id);
        if (optionalProcedura.isPresent()) {
            Procedura procedura = optionalProcedura.get();
            procedura.setDenumire(denumire);
            proceduraRepository.save(procedura);
        } else {
            throw new RuntimeException("Material not found with id " + id);
        }
    }
    public List<Procedura> sortProcedurasByDenumire() {
        List<Procedura> proceduras = proceduraRepository.findAll();

        // Utilizăm un Comparator pentru a sorta procedurile în funcție de denumire
        Comparator<Procedura> comparator = Comparator.comparing(Procedura::getDenumire);
        Collections.sort(proceduras, comparator);

        return proceduras;
    }
    public List<Procedura> filetrProceduraByAparatura(Long idAparatura) {
        return proceduraRepository.findByAparaturaId(idAparatura);

    }
}