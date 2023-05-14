package com.example.clinica.services;

import com.example.clinica.dtos.AparaturaDTO;
import com.example.clinica.entities.Aparatura;
import com.example.clinica.entities.Material;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.clinica.repositories.AparaturaRepository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

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
    public void updateAparatura(Long id, String denumire)
    {
        Optional<Aparatura> optionalAparatura = aparaturaRepository.findById(id);
        if (optionalAparatura.isPresent()) {
            Aparatura aparatura = optionalAparatura.get();
            aparatura.setDenumire(denumire);
            aparaturaRepository.save(aparatura);
        } else {
            throw new RuntimeException("Material not found with id " + id);
        }
    }
    public List<Aparatura> sortAparaturiByDenumire() {
        List<Aparatura> aparaturi = aparaturaRepository.findAll();

        // Utilizăm un Comparator pentru a sorta aparaturile în funcție de denumire
        Comparator<Aparatura> comparator = Comparator.comparing(Aparatura::getDenumire);
        Collections.sort(aparaturi, comparator);

        return aparaturi;
    }
}