package com.example.clinicarecuperare;


import jakarta.persistence.*;

@Entity
public class Specializare {
    @Id
    @GeneratedValue
    private int idSpecializare;
    private String Denumire;

    public Specializare(String denumire) {
        this.idSpecializare=0;
        Denumire = denumire;
    }

    public Specializare() {

    }

    public String getDenumire() {
        return Denumire;
    }

    public void setDenumire(String denumire) {
        Denumire = denumire;
    }

    public void setIdSpecializare(int idSpecializare) {
        this.idSpecializare = idSpecializare;
    }

    public int getIdSpecializare() {
        return idSpecializare;
    }
    public void adaugaSpecializare() {
        // Crearea unui EntityManagerFactory bazat pe configurația din persistence.xml
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("your-persistence-unit-name");

        // Crearea unui EntityManager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Începerea unei tranzacții
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        try {
            // Adăugarea specializării în baza de date
            entityManager.persist(this);

            // Confirmarea tranzacției
            transaction.commit();

            System.out.println("Specializare adăugată cu succes!");
        } catch (Exception e) {
            // Anularea tranzacției în caz de eroare
            transaction.rollback();
            e.printStackTrace();
        } finally {
            // Închiderea EntityManager-ului
            entityManager.close();

            // Închiderea EntityManagerFactory
            entityManagerFactory.close();
        }
    }

}
