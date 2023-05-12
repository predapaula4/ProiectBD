package com.example.clinica.services;

import com.example.clinica.dtos.AparaturaDTO;
import com.example.clinica.entities.Aparatura;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.clinica.repositories.AparaturaRepository;

import java.util.List;

@Service
public class AparaturaServices {

    @Autowired
    private AparaturaRepository aparaturaRepository;

    public void createAparatura(AparaturaDTO aparaturaDTO) {
        Aparatura aparatura = new Aparatura();
        BeanUtils.copyProperties(aparaturaDTO, aparatura);
        aparaturaRepository.save(aparatura);
    }

    public Aparatura getAparaturaById(Long id) {
        return aparaturaRepository.findById(id).orElse(null);
    }

    public List<Aparatura> getAllAparaturas() {
        return aparaturaRepository.findAll();
    }
    public void deleteAparaturaById(Long id)
    {
        aparaturaRepository.deleteById(id);
    }
}