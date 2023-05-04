package org.example;

import lombok.Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    public Specializare(){

    }

    public Specializare(int idSpecializare) {
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
    public void printAll() {
        String sql = "SELECT * FROM Specializare";
        DatabaseConnection dbConn = new DatabaseConnection();
        Connection conn = dbConn.getConnection();

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int IdSpecializare = rs.getInt("IdSpecializare");
                String Denumire = rs.getString("Denumire");
                System.out.println("IdSpecializare: " + IdSpecializare + ", Denumire: " + Denumire);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
    }
    public  void deleteById(int id) {
        String sql = "DELETE FROM Specializare WHERE IdSpecializare = ?";
        DatabaseConnection dbConn = new DatabaseConnection();
        Connection conn = dbConn.getConnection();

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Specializarea cu id-ul " + id + " a fost ștearsă din baza de date.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
    }
    public  void deleteByDenumire(String denumire) {
        String sql = "DELETE FROM Specializare WHERE Denumire = ?";
        DatabaseConnection dbConn = new DatabaseConnection();
        Connection conn = dbConn.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, denumire);
            pstmt.executeUpdate();
            System.out.println("Specializarea cu denumirea " + denumire + " a fost ștearsă din baza de date.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
    }
    public Specializare findById(int id) {
        String sql = "SELECT * FROM Specializare WHERE IdSpecializare = ?";
        DatabaseConnection dbConn = new DatabaseConnection();
        Connection conn = dbConn.getConnection();

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String Denumire = rs.getString("Denumire");
                return new Specializare(id, Denumire);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return null;
    }

}