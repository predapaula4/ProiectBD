package com.example.clinica.dtos;

public class AfectiuneDTO {
    private String denumire;
    private int idProcedura;

    public AfectiuneDTO() {}

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getIdProcedura() {
        return idProcedura;
    }

    public void setIdProcedura(int idProcedura) {
        this.idProcedura = idProcedura;
    }
}