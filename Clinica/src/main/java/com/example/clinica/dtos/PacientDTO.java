package com.example.clinica.dtos;

import org.springframework.stereotype.Component;

@Component
public class PacientDTO {
    private Long idAfectiune;
    private Long idProgramare;
    private String nume;
    private String prenume;
    private Long varsta;

    public PacientDTO() {}

    public Long getIdAfectiune() {
        return idAfectiune;
    }

    public void setIdAfectiune(Long idAfectiune) {
        this.idAfectiune = idAfectiune;
    }

    public Long getIdProgramare() {
        return idProgramare;
    }

    public void setIdProgramare(Long idProgramare) {
        this.idProgramare = idProgramare;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public Long getVarsta() {
        return varsta;
    }

    public void setVarsta(Long varsta) {
        this.varsta = varsta;
    }
}