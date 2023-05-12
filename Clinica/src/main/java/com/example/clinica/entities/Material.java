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

    public Material() {}
}