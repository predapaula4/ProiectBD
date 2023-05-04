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

    public Afectiune() {

    }

    public Afectiune(int idAfectiune) {
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
    public  void deleteById(int id) {
        String sql = "DELETE FROM Afectiune WHERE IdAfectiune = ?";
        DatabaseConnection dbConn = new DatabaseConnection();
        Connection conn = dbConn.getConnection();

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Afectiunea cu id-ul " + id + " a fost ștearsă din baza de date.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
    }
    public  void deleteByDenumire(String denumire) {
        String sql = "DELETE FROM Afectiune WHERE Denumire = ?";
        DatabaseConnection dbConn = new DatabaseConnection();
        Connection conn = dbConn.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, denumire);
            pstmt.executeUpdate();
            System.out.println("Afectiunea cu denumirea " + denumire + " a fost ștearsă din baza de date.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
    }
    public static void printAll() {
        String sql = "SELECT * FROM Afectiune";
        DatabaseConnection dbConn = new DatabaseConnection();
        Connection conn = dbConn.getConnection();

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                int IdAfectiune = rs.getInt("IdAfectiune");
                String Denumire = rs.getString("Denumire");
                int IdProcedura = rs.getInt("IdProcedura");

                System.out.println("IdAfectiune: " + IdAfectiune + ", Denumire: " + Denumire + ", IdProcedura: " + IdProcedura);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
    }
    public static Afectiune findById(int id) {
        String sql = "SELECT * FROM Afectiune WHERE IdAfectiune = ?";
        DatabaseConnection dbConn = new DatabaseConnection();
        Connection conn = dbConn.getConnection();
        Afectiune afectiune = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String denumire = rs.getString("Denumire");
                int idProcedura = rs.getInt("IdProcedura");
                Procedura procedura = Procedura.findById(idProcedura);
                afectiune = new Afectiune(id, denumire, procedura);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return afectiune;

    }
}

