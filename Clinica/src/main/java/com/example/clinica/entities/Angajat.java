package com.example.clinica.entities;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "angajat")
public class Angajat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idangajat")
    private int idAngajat;

    @Column(name = "idspecializare")
    private int idSpecializare;

    @Column(name = "nume", length = 20)
    private String nume;

    @Column(name = "prenume", length = 20)
    private String prenume;

    @Column(name = "salariu")
    private int salariu;
    @Override
    public String toString() {
        return "Material{" +
                "idAngajat=" + idAngajat +
                ", nume='" + nume + '\'' +
                ",prenume='"+ prenume+ '\''+
                ",salariu='"+ salariu+'\''+
                '}'+"\n";
    }


    public Angajat() {}


}