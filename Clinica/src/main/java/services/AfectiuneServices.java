package services;

import dtos.AfectiuneDTO;
import entities.Afectiune;
import entities.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.AfectiuneRepository;

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
}