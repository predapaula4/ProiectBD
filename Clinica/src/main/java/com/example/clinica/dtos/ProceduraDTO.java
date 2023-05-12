package com.example.clinica.dtos;

public class ProceduraDTO {
    private String denumire;
    private int idAfectiune;
    private int idAparatura;
    private int idMaterial;

    public ProceduraDTO() {}

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getIdAfectiune() {
        return idAfectiune;
    }

    public void setIdAfectiune(int idAfectiune) {
        this.idAfectiune = idAfectiune;
    }

    public int getIdAparatura() {
        return idAparatura;
    }

    public void setIdAparatura(int idAparatura) {
        this.idAparatura = idAparatura;
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }
}