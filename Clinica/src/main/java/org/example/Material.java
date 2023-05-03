package org.example;

import lombok.Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Data
public class Material {
    private int IdMaterial;
    private String Denumire;

    public Material(String Denumire) {
        this.IdMaterial=0;
        this.Denumire = Denumire;
    }
    public Material(int IdMaterial, String Denumire) {
        this.IdMaterial=IdMaterial;
        this.Denumire = Denumire;
    }

    public void save() {
        String sql = "INSERT INTO Material (Denumire) VALUES ( ?)";
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
