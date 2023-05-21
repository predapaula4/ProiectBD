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


    public Aparatura() {}


    @Override
    public String toString() {
        return "Aparatura{" +
                "idAparatura=" + idAparatura +
                ", denumire='" + denumire + '\'' +
                '}'+"\n";
    }
}