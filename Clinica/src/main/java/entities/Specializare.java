package entities;

import jakarta.persistence.*;
import org.springframework.data.relational.core.mapping.Table;


@Entity
@Table(name = "specializare")
public class Specializare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSpecializare;

    @Column(name = "denumire", length = 20)
    private String denumire;

    public Specializare() {}

    public Long getIdSpecializare() {
        return idSpecializare;
    }

    public void setIdSpecializare(Long idSpecializare) {
        this.idSpecializare = idSpecializare;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }
}