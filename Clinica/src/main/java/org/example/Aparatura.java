package org.example;

import lombok.Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    public Aparatura(){

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
    }
    public void printAll() {
        String sql = "SELECT * FROM Aparatura";
        DatabaseConnection dbConn = new DatabaseConnection();
        Connection conn = dbConn.getConnection();

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("IdAparatura: " + rs.getInt("IdAparatura")+", Denumire: " + rs.getString("Denumire"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
    }
    public  void deleteById(int id) {
        String sql = "DELETE FROM Aparatura WHERE IdAparatura = ?";
        DatabaseConnection dbConn = new DatabaseConnection();
        Connection conn = dbConn.getConnection();

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Aparatul cu id-ul " + id + " a fost ștearsă din baza de date.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
    }
    public  void deleteByDenumire(String denumire) {
        String sql = "DELETE FROM Aparatura WHERE Denumire = ?";
        DatabaseConnection dbConn = new DatabaseConnection();
        Connection conn = dbConn.getConnection();

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, denumire);
            pstmt.executeUpdate();
            System.out.println("Aparatul cu denumirea " + denumire + " a fost ștearsă din baza de date.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
    }
    public static Aparatura findById(int id) {
        String sql = "SELECT * FROM Aparatura WHERE IdAparatura = ?";
        DatabaseConnection dbConn = new DatabaseConnection();
        Connection conn = dbConn.getConnection();
        Aparatura aparatura = null;

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int IdAparatura = rs.getInt("IdAparatura");
                String Denumire = rs.getString("Denumire");
                aparatura = new Aparatura(IdAparatura, Denumire);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return aparatura;
    }

}
