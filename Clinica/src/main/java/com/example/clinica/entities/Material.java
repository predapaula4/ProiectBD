package com.example.clinica.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "material")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idmaterial")
    private Long idMaterial;

    @Column(name = "denumire")
    private String denumire;

    @Override
    public String toString() {
        return "Material{" +
                "idmaterial=" + idMaterial +
                ", denumire='" + denumire + '\'' +
                '}'+"\n";
    }
    public Material() {}

    public Long getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Long idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }
}