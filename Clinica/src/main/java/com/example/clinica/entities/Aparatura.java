package com.example.clinica.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "aparatura")
public class Aparatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idaparatura")
    private Long idAparatura;

    @Column(name = "denumire")
    private String denumire;
    @Override
    public String toString() {
        return "Material{" +
                "idAparatura=" + idAparatura +
                ", denumire='" + denumire + '\'' +
                '}'+"\n";
    }

    public Aparatura() {}


}