package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "aparatura")
public class Aparatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAparatura;

    @Column(name = "denumire")
    private String denumire;

    public Aparatura() {}

    public Long getIdAparatura() {
        return idAparatura;
    }

    public void setIdAparatura(Long idAparatura) {
        this.idAparatura = idAparatura;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }
}