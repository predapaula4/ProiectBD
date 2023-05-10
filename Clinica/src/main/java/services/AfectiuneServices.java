package services;

import dtos.AfectiuneDTO;
import entities.Afectiune;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.AfectiuneRepository;

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
}