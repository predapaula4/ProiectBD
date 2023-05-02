package org.example;

import lombok.Data;
import org.example.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
// Getters and Setters
@Data
public class Angajat {
    private int idSpecializare;
    private String nume;
    private String prenume;
    private int salariu;

    public Angajat(int idSpecializare, String nume, String prenume, int salariu) {
        this.idSpecializare = idSpecializare;
        this.nume = nume;
        this.prenume = prenume;
        this.salariu = salariu;
    }



    public void save() {
        String sql = "INSERT INTO Angajat (IdSpecializare, Nume, Prenume, Salariu) VALUES (?, ?, ?, ?)";
        DatabaseConnection dbConn = new DatabaseConnection();
        Connection conn = dbConn.getConnection();

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, idSpecializare);
            pstmt.setString(2, nume);
            pstmt.setString(3, prenume);
            pstmt.setInt(4, salariu);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
    }
}