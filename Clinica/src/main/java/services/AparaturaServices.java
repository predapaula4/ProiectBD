package services;

import dtos.AparaturaDTO;
import entities.Aparatura;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.AparaturaRepository;

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
}