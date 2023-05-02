package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Angajat {
    private int idAngajat;
    private int idSpecializare;
    private String nume;
    private String prenume;
    private int salariu;

    public Angajat(int idAngajat, int idSpecializare, String nume, String prenume, int salariu) {
        this.idAngajat = idAngajat;
        this.idSpecializare = idSpecializare;
        this.nume = nume;
        this.prenume = prenume;
        this.salariu = salariu;
    }

    // Getters and Setters

    public void save() {
        String sql = "INSERT INTO Angajat (IdAngajat, IdSpecializare, Nume, Prenume, Salariu) VALUES (?, ?, ?, ?, ?)";
        DatabaseConnection dbConn = new DatabaseConnection();
        Connection conn = dbConn.getConnection();

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, idAngajat);
            pstmt.setInt(2, idSpecializare);
            pstmt.setString(3, nume);
            pstmt.setString(4, prenume);
            pstmt.setInt(5, salariu);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
    }
}