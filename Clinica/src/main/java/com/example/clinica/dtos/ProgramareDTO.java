package com.example.clinica.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

public class ProgramareDTO {
    private int idProgramare;
    private int idPacient;
    private int idAngajat;
    private LocalDate dataConsultatie;
    private LocalTime oraConsultatiei;

    public ProgramareDTO() {}
    public int getIdProgramare(){return idProgramare;}
    public int getIdPacient() {
        return idPacient;
    }

    public void setIdPacient(int idPacient) {
        this.idPacient = idPacient;
    }

    public int getIdAngajat() {
        return idAngajat;
    }

    public void setIdAngajat(int idAngajat) {
        this.idAngajat = idAngajat;
    }

    public LocalDate getDataConsultatie() {
        return dataConsultatie;
    }

    public void setDataConsultatie(LocalDate dataConsultatie) {
        this.dataConsultatie = dataConsultatie;
    }

    public LocalTime getOraConsultatiei() {
        return oraConsultatiei;
    }

    public void setOraConsultatiei(LocalTime oraConsultatiei) {
        this.oraConsultatiei = oraConsultatiei;
    }
}