package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Afectiune")
public class Afectiune {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAfectiune;

    @Column(name = "Denumire")
    private String denumire;

    @Column(name = "IdProcedura")
    private int idProcedura;

    public Afectiune() {}

    public Long getIdAfectiune() {
        return idAfectiune;
    }

    public void setIdAfectiune(Long idAfectiune) {
        this.idAfectiune = idAfectiune;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getIdProcedura() {
        return idProcedura;
    }

    public void setIdProcedura(int idProcedura) {
        this.idProcedura = idProcedura;
    }
}