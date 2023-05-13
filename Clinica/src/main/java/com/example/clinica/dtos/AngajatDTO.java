package com.example.clinica.dtos;


public class AngajatDTO {
    private Long idSpecializare;
    private String nume;
    private String prenume;
    private Long salariu;

    public AngajatDTO() {}

    public Long getIdSpecializare() {
        return idSpecializare;
    }

    public void setIdSpecializare(Long idSpecializare) {
        this.idSpecializare = idSpecializare;
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

    public Long getSalariu() {
        return salariu;
    }

    public void setSalariu(Long salariu) {
        this.salariu = salariu;
    }
}
