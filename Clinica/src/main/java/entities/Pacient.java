package entities;
import jakarta.persistence.*;
import org.springframework.data.relational.core.mapping.Table;

@Entity
@Table(name = "pacient")
public class Pacient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Pacient() {}

    public Long getIdPacient() {
        return idPacient;
    }

    public void setIdPacient(Long idPacient) {
        this.idPacient = idPacient;
    }

    public int getIdAfectiune() {
        return idAfectiune;
    }

    public void setIdAfectiune(int idAfectiune) {
        this.idAfectiune = idAfectiune;
    }

    public int getIdProgramare() {
        return idProgramare;
    }

    public void setIdProgramare(int idProgramare) {
        this.idProgramare = idProgramare;
    }

    public String getNume() {
        return nume;
    }
    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }
}