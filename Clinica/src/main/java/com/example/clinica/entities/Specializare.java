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

    public Specializare() {}
    @Override
    public String toString() {
        return "Specializare{" +
                "idSpecializare=" + idSpecializare +
                ", denumire='" + denumire + '\'' +
                '}';
    }
}