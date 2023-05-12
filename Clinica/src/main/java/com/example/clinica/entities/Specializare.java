package com.example.clinica.entities;

import jakarta.persistence.*;



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

    public Long getIdSpecializare() {
        return idSpecializare;
    }

    public void setIdSpecializare(Long idSpecializare) {
        this.idSpecializare = idSpecializare;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }
}