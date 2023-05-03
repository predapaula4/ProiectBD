package org.example;

import lombok.Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
// Getters and Setters
@Data
public class Angajat {
    private int IdAngajat;
    private int idSpecializare;
    private String Nume;
    private String Prenume;

    private int salariu;
    public Angajat(int idSpecializare, String nume, String prenume, int salariu) {
        this.IdAngajat=0;
        this.idSpecializare = idSpecializare;
        this.Nume = nume;
        this.Prenume = prenume;
        this.salariu = salariu;
    }
    public Angajat(int IdAngajat, int idSpecializare, String nume, String prenume, int salariu) {
        this.IdAngajat=IdAngajat;
        this.idSpecializare = idSpecializare;
        this.Nume = nume;
        this.Prenume = prenume;
        this.salariu = salariu;
    }
    public Angajat(){

    }
    public void save() {
        String sql = "INSERT INTO Angajat (IdSpecializare, Nume, Prenume, Salariu) VALUES (?, ?, ?, ?)";
        DatabaseConnection dbConn = new DatabaseConnection();
        Connection conn = dbConn.getConnection();

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, idSpecializare);
            pstmt.setString(2, Nume);
            pstmt.setString(3, Prenume);
            pstmt.setInt(4, salariu);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
    }
    public  void deleteAllByNP(String nume, String prenume) {
        String sql = "DELETE FROM Angajat WHERE Nume = ? AND Prenume = ?";
        DatabaseConnection dbConn = new DatabaseConnection();
        Connection conn = dbConn.getConnection();

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nume);
            pstmt.setString(2, prenume);
            pstmt.executeUpdate();
            System.out.println("Angajatul cu numele" + nume+" si prenumele "+prenume + " a fost ștears din baza de date.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
    }
    public  void deleteById(int id) {
        String sql = "DELETE FROM Angajat WHERE IdAngajat = ?";
        DatabaseConnection dbConn = new DatabaseConnection();
        Connection conn = dbConn.getConnection();

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Angajatul cu id-ul " + id + " a fost ștearsă din baza de date.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
    }
    public static void printAll() {
        String sql = "SELECT * FROM Angajat";
        DatabaseConnection dbConn = new DatabaseConnection();
        Connection conn = dbConn.getConnection();

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("IdAngajat");
                int idSpecializare = rs.getInt("IdSpecializare");
                String nume = rs.getString("Nume");
                String prenume = rs.getString("Prenume");
                int salariu = rs.getInt("Salariu");
                Angajat angajat = new Angajat(id, idSpecializare, nume, prenume, salariu);
                System.out.println(angajat.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
    }

}