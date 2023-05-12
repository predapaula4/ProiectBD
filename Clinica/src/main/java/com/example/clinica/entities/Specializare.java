package com.example.clinica.entities;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "specializare")
public class Specializare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idspecializare")
    private Long idSpecializare;

    @Column(name = "denumire", length = 20)
    private String denumire;
    @Override
    public String toString() {
        return "Material{" +
                "idmaterial=" + idSpecializare +
                ", denumire='" + denumire + '\'' +
                '}'+"\n";
    }
    public Specializare() {}


}