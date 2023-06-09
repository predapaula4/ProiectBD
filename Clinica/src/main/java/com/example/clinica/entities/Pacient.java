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
    private Long idAfectiune;

    @Column(name = "idprogramare")
    private Long idProgramare;

    @Column(name = "nume", length = 20)
    private String nume;

    @Column(name = "prenume", length = 20)
    private String prenume;

    @Column(name = "varsta")
    private Long varsta;


    public Pacient() {}


    @Override
    public String toString() {
        return "Pacient{" +
                "idPacient=" + idPacient +
                ", idAfectiune=" + idAfectiune +
                ", idProgramare=" + idProgramare +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", varsta=" + varsta +
                '}'+"\n";
    }
}