package com.example.clinica.entities;

import jakarta.persistence.*;
import lombok.Data;
@Data
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
                "idMaterial=" + idMaterial +
                ", denumire='" + denumire + '\'' +
                '}'+"\n";
    }
    public Material() {}

}