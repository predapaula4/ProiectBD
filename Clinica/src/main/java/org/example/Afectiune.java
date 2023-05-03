package org.example;

import lombok.Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Data
public class Afectiune {
    private int IdAfectiune;
    private String Denumire;
    private Procedura IdProcedura;
    // Constructor without idAfectiune (assumes auto-increment)
    public Afectiune( String Denumire, Procedura IdProcedura) {
        this.IdAfectiune=0;//auto-increment
        this.Denumire = Denumire;
        this.IdProcedura = IdProcedura;
    }
    // Constructor with idAfectiune (for retrieving existing records)
    public Afectiune(int IdAfectiune, String Denumire, Procedura IdProcedura) {
        this.IdAfectiune=IdAfectiune;
        this.Denumire = Denumire;
        this.IdProcedura = IdProcedura;
    }

    public void save() {
        String sql = "INSERT INTO Angajat (Denumire,IdProcedura) VALUES (?, ?)";
        DatabaseConnection dbConn = new DatabaseConnection();
        Connection conn = dbConn.getConnection();

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Denumire);
            pstmt.setInt(2, IdProcedura.getIdProcedura());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
    }

}
