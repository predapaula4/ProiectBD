package org.example;

import lombok.Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Data
public class Specializare {
    private int IdSpecializare;
    private String Denumire;

    public Specializare(String Denumire) {
        this.IdSpecializare=0;
        this.Denumire = Denumire;
    }
    public Specializare(int IdSpecializare, String Denumire) {
        this.IdSpecializare=IdSpecializare;
        this.Denumire = Denumire;
    }

    public void save() {
        String sql = "INSERT INTO Specilizare (Denumire) VALUES ( ?)";
        DatabaseConnection dbConn = new DatabaseConnection();
        Connection conn = dbConn.getConnection();

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Denumire);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }


    }
}