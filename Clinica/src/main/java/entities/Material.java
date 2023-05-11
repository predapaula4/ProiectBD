package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "material")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMaterial;

    @Column(name = "denumire")
    private String denumire;

    public Material() {}

    public Long getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Long idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }
}