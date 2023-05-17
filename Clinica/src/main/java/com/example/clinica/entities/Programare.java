package com.example.clinica.entities;

import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDate;
import java.time.LocalTime;
@Data
@Entity
@Table(name = "programare")
public class Programare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idprogramare")
    private Long idProgramare;

    @Column(name = "idpacient")
    private Long idPacient;

    @Column(name = "idangajat")
    private Long idAngajat;

    @Column(name = "dataconsultatie")
    private LocalDate dataConsultatie;

    @Column(name = "oraconsultatiei")
    private LocalTime oraConsultatiei;

    public Programare() {}


    @Override
    public String toString() {
        return "Programare{" +
                "idProgramare=" + idProgramare +
                ", idPacient=" + idPacient +
                ", idAngajat=" + idAngajat +
                ", dataConsultatie=" + dataConsultatie +
                ", oraConsultatiei=" + oraConsultatiei +
                '}';
    }
}
