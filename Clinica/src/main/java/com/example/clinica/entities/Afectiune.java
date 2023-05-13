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
    @Override
    public String toString() {
        return "Material{" +
                "idAfectiune=" + idAfectiune +
                ", denumire='" + denumire + '\'' +
                ",idProcedura='"+ idProcedura+ '\''+
                '}'+"\n";
    }

    public Afectiune() {}


}