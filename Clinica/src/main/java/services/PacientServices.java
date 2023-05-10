package services;

import dtos.PacientDTO;
import entities.Pacient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.PacientRepository;

@Service
public class PacientServices {

    @Autowired
    private PacientRepository pacientRepository;

    public void createPacient(PacientDTO pacientDTO) {
        Pacient pacient = new Pacient();
        pacient.setIdAfectiune(pacientDTO.getIdAfectiune());
        pacient.setIdProgramare(pacientDTO.getIdProgramare());
        pacient.setNume(pacientDTO.getNume());
        pacient.setPrenume(pacientDTO.getPrenume());
        pacient.setVarsta(pacientDTO.getVarsta());

        pacientRepository.save(pacient);
    }

    public Pacient getPacientById(Long id) {
        return pacientRepository.findById(id).orElse(null);
    }
}