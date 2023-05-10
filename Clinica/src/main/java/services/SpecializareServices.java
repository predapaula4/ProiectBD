package services;

import dtos.SpecializareDTO;
import entities.Specializare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.SpecializareRepository;

@Service
public class SpecializareServices {

    @Autowired
    private SpecializareRepository specializareRepository;

    public void createSpecializare(SpecializareDTO specializareDTO) {
        Specializare specializare = new Specializare();
        specializare.setDenumire(specializareDTO.getDenumire());

        specializareRepository.save(specializare);
    }

    public Specializare getSpecializareById(Long id) {
        return specializareRepository.findById(id).orElse(null);
    }
}