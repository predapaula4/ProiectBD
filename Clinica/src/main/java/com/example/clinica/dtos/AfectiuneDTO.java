package com.example.clinica.dtos;

public class AfectiuneDTO {
    private String denumire;
    private Long idProcedura;

    public AfectiuneDTO() {}

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public Long getIdProcedura() {
        return idProcedura;
    }

    public void setIdProcedura(Long idProcedura) {
        this.idProcedura = idProcedura;
    }
}