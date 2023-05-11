package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "procedura")
public class Procedura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProcedura;

    @Column(name = "denumire")
    private String denumire;

    @Column(name = "idafectiune")
    private int idAfectiune;

    @Column(name = "idaparatura")
    private int idAparatura;

    @Column(name = "idmaterial")
    private int idMaterial;

    public Procedura() {}

    public Long getIdProcedura() {
        return idProcedura;
    }

    public void setIdProcedura(Long idProcedura) {
        this.idProcedura = idProcedura;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getIdAfectiune() {
        return idAfectiune;
    }

    public void setIdAfectiune(int idAfectiune) {
        this.idAfectiune = idAfectiune;
    }

    public int getIdAparatura() {
        return idAparatura;
    }

    public void setIdAparatura(int idAparatura) {
        this.idAparatura = idAparatura;
    }

    public int getIdMaterial() {
        return idMaterial;
    }
    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }
}

