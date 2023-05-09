package entities;


import jakarta.persistence.*;

@Entity
@Table(name = "Angajat")
public class Angajat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAngajat;

    @Column(name = "IdSpecializare")
    private int idSpecializare;

    @Column(name = "Nume", length = 20)
    private String nume;

    @Column(name = "Prenume", length = 20)
    private String prenume;

    @Column(name = "Salariu")
    private int salariu;

    public Angajat() {}

    public int getIdAngajat() {
        return idAngajat;
    }

    public void setIdAngajat(int idAngajat) {
        this.idAngajat = idAngajat;
    }

    public int getIdSpecializare() {
        return idSpecializare;
    }

    public void setIdSpecializare(int idSpecializare) {
        this.idSpecializare = idSpecializare;
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

    public int getSalariu() {
        return salariu;
    }

    public void setSalariu(int salariu) {
        this.salariu = salariu;
    }
}