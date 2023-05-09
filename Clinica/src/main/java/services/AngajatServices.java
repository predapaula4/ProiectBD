package services;

import dtos.AngajatDTO;
import entities.Angajat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.AngajatRepository;

@Service
public class AngajatServices {
    @Autowired
    private AngajatRepository angajatRepository;
    public void createAngajat(AngajatDTO angajatDTO) {
        Angajat angajat = new Angajat();
        angajat.setIdSpecializare(Math.toIntExact(angajatDTO.getIdSpecializare()));
        angajat.setNume(angajatDTO.getNume());
        angajat.setPrenume(angajatDTO.getPrenume());
        angajat.setSalariu(angajatDTO.getSalariu());

        angajatRepository.save(angajat);
    }
    public Angajat getAngajatById(int id) {
        return angajatRepository.findById((long) id).orElse(null);
    }
}
