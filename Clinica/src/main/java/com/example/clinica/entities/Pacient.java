package com.example.clinica.entities;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "pacient")
public class Pacient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idpacient")
    private Long idPacient;

    @Column(name = "idafectiune")
    private int idAfectiune;

    @Column(name = "idprogramare")
    private int idProgramare;

    @Column(name = "nume", length = 20)
    private String nume;

    @Column(name = "prenume", length = 20)
    private String prenume;

    @Column(name = "varsta")
    private int varsta;

    @Override
    public String toString() {
        return "Material{" +
                "idPacient=" + idPacient +
                ", nume='" + nume + '\'' +
                ",prenume='"+ prenume+ '\''+
                ",varsta='"+ varsta+'\''+
                '}'+"\n";
    }
    public Pacient() {}


}