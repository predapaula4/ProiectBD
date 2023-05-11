package entities;

import jakarta.persistence.*;

import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "programare")
public class Programare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProgramare;

    @Column(name = "idpacient")
    private int idPacient;

    @Column(name = "idangajat")
    private int idAngajat;

    @Column(name = "dataconsultatie")
    private LocalDate dataConsultatie;

    @Column(name = "oraconsultatiei")
    private LocalTime oraConsultatiei;

    public Programare() {}

    public Long getIdProgramare() {
        return idProgramare;
    }

    public void setIdProgramare(Long idProgramare) {
        this.idProgramare = idProgramare;
    }

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