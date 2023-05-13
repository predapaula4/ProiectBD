package com.example.clinica.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

public class ProgramareDTO {
    private Long idProgramare;
    private Long idPacient;
    private Long idAngajat;
    private LocalDate dataConsultatie;
    private LocalTime oraConsultatiei;

    public ProgramareDTO() {}
    public Long getIdProgramare(){return idProgramare;}
    public Long getIdPacient() {
        return idPacient;
    }

    public void setIdPacient(Long idPacient) {
        this.idPacient = idPacient;
    }

    public Long getIdAngajat() {
        return idAngajat;
    }

    public void setIdAngajat(Long idAngajat) {
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