package com.example.clinica.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "procedura")
public class Procedura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idprocedura")
    private Long idProcedura;

    @Column(name = "denumire")
    private String denumire;

    @Column(name = "idafectiune")
    private Long idAfectiune;

    @Column(name = "idaparatura")
    private Long idAparatura;

    @Column(name = "idmaterial")
    private Long idMaterial;

    @Override
    public String toString() {
        return "Material{" +
                "idProcedura=" + idProcedura +
                ", denumire='" + denumire + '\'' +
                ",idAfectiune='"+ idAfectiune+ '\''+
                ",idAparatura='"+ idAparatura+'\''+
                ",idMaterial='"+ idMaterial+'\''+
                '}'+"\n";
    }
    public Procedura() {}


}

