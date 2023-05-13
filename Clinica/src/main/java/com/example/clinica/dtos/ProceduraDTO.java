package com.example.clinica.dtos;

public class ProceduraDTO {
    private String denumire;
    private Long idAfectiune;
    private Long idAparatura;
    private Long idMaterial;

    public ProceduraDTO() {}

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public Long getIdAfectiune() {
        return idAfectiune;
    }

    public void setIdAfectiune(Long idAfectiune) {
        this.idAfectiune = idAfectiune;
    }

    public Long getIdAparatura() {
        return idAparatura;
    }

    public void setIdAparatura(Long idAparatura) {
        this.idAparatura = idAparatura;
    }

    public Long getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Long idMaterial) {
        this.idMaterial = idMaterial;
    }
}