package org.example;

import lombok.Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Data
public class Aparatura {
    private int IdAparatura;
    private String Denumire;
    public Aparatura(String Denumire)
    {
        this.IdAparatura=0;
        this.Denumire=Denumire;
    }
    public Aparatura(int IdAparatura, String Denumire)
    {
        this.IdAparatura=IdAparatura;
        this.Denumire=Denumire;
    }
    public void save() {
        String sql = "INSERT INTO Aparatura (Denumire) VALUES (?)";
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


    }}
