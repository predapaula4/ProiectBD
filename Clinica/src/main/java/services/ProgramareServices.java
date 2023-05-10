package services;

import dtos.ProgramareDTO;
import entities.Programare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.ProgramareRepository;

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
}