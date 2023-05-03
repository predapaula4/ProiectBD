package org.example;

import lombok.Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class Procedura {
    private int IdProcedura;
   private String Denumire;
   private Afectiune IdAfectiune;
   private Aparatura IdAparatura;
   private Material IdMaterial;
   public Procedura(String Denumire, Afectiune IdAfectiune, Aparatura IdAparatura, Material IdMaterial)
   {
       this.IdProcedura=0;
       this.Denumire=Denumire;
       this.IdAfectiune=IdAfectiune;
       this.IdAparatura=IdAparatura;
       this.IdMaterial=IdMaterial;
   }
    public Procedura(int IdProcedura, String Denumire, Afectiune IdAfectiune, Aparatura IdAparatura, Material IdMaterial)
    {
        this.IdProcedura=IdProcedura;
        this.Denumire=Denumire;
        this.IdAfectiune=IdAfectiune;
        this.IdAparatura=IdAparatura;
        this.IdMaterial=IdMaterial;
    }
    public Procedura(){

    }
    public void save() {
        String sql = "INSERT INTO Procedura (Denumire,IdAfectiune, IdAparatura, IdMaterial) VALUES (?,?,?, ?)";
        DatabaseConnection dbConn = new DatabaseConnection();
        Connection conn = dbConn.getConnection();

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Denumire);
            pstmt.setInt(2, IdAfectiune.getIdAfectiune());
            pstmt.setInt(3, IdAparatura.getIdAparatura());
            pstmt.setInt(4,IdMaterial.getIdMaterial());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
    }
    public  void deleteById(int id) {
        String sql = "DELETE FROM Procedura WHERE IdProcedura = ?";
        DatabaseConnection dbConn = new DatabaseConnection();
        Connection conn = dbConn.getConnection();

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Procedura cu id-ul " + id + " a fost ștearsă din baza de date.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
    }
    public void deleteByDenumire(String denumire) {
        String sql = "DELETE FROM Procedura WHERE Denumire = ?";
        DatabaseConnection dbConn = new DatabaseConnection();
        Connection conn = dbConn.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, denumire);
            pstmt.executeUpdate();
            System.out.println("Procedura cu denumirea " + denumire + " a fost ștearsă din baza de date.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
    }
    public  void printAll() {
        String sql = "SELECT * FROM Procedura";
        DatabaseConnection dbConn = new DatabaseConnection();
        Connection conn = dbConn.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int IdProcedura = rs.getInt("IdProcedura");
                String Denumire = rs.getString("Denumire");
                int IdAfectiune = rs.getInt("IdAfectiune");
                int IdAparatura = rs.getInt("IdAparatura");
                int IdMaterial = rs.getInt("IdMaterial");

                System.out.println("IdProcedura: " + IdProcedura + ", Denumire: " + Denumire + ", IdAfectiune: " + IdAfectiune + ", IdAparatura: " + IdAparatura + ", IdMaterial: " + IdMaterial);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }

    }

}
