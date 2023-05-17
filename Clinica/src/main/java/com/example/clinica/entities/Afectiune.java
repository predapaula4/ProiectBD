package com.example.clinica.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
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
    private Long idProcedura;

    public Afectiune() {}


    @Override
    public String toString() {
        return "Afectiune{" +
                "idAfectiune=" + idAfectiune +
                ", denumire='" + denumire + '\'' +
                ", idProcedura=" + idProcedura +
                '}';
    }
}