package com.example.clinica.services;

import com.example.clinica.dtos.ProceduraDTO;
import com.example.clinica.entities.Procedura;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.clinica.repositories.ProceduraRepository;

import java.util.List;

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
}