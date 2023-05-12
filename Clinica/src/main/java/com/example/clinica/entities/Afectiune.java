package com.example.clinica.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "afectiune")
public class Afectiune {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idafectiune")
    private Long idAfectiune;

    @Column(name = "denumire")
    private String denumire;

    @Column(name = "idprocedura")
    private int idProcedura;

    public Afectiune() {}

    public Long getIdAfectiune() {
        return idAfectiune;
    }

    public void setIdAfectiune(Long idAfectiune) {
        this.idAfectiune = idAfectiune;
    }

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