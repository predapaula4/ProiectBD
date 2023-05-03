package org.example;

import lombok.Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Data
public class Cabinet {
    private int IdCabinet;
    private String Denumire;
    private Pacient IdPacient;
    private Specializare IdSpecialiare;
    private Procedura IdProcedura;
    Cabinet(String Denumire, Pacient IdPacient, Specializare IdSpecializare, Procedura IdProcedura)
    {
        this.IdCabinet=0;
        this.Denumire=Denumire;
        this.IdPacient=IdPacient;
        this.IdSpecialiare=IdSpecializare;
        this.IdProcedura=IdProcedura;
    }
    Cabinet(int IdCabinet, String Denumire, Pacient IdPacient, Specializare IdSpecializare, Procedura IdProcedura)
    {
        this.IdCabinet=IdCabinet;
        this.Denumire=Denumire;
        this.IdPacient=IdPacient;
        this.IdSpecialiare=IdSpecializare;
        this.IdProcedura=IdProcedura;
    }
    public Cabinet(){

    }
    public void save() {
        String sql = "INSERT INTO Cabinet (Denumire,IdPacient, IdSpecializare, IdProcedura) VALUES (?,?,?,?)";
        DatabaseConnection dbConn = new DatabaseConnection();
        Connection conn = dbConn.getConnection();

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Denumire);
            pstmt.setInt(2, IdPacient.getIdPacient());
            pstmt.setInt(3,IdSpecialiare.getIdSpecializare());
            pstmt.setInt(4,IdProcedura.getIdProcedura());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
    }
    public void deleteByDenumire(String denumire) {
        String sql = "DELETE FROM Cabinet WHERE Denumire = ?";
        DatabaseConnection dbConn = new DatabaseConnection();
        Connection conn = dbConn.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, denumire);
            pstmt.executeUpdate();
            System.out.println("Cabinetul cu denumirea " + denumire + " a fost șters din baza de date.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
    }
    public void deleteById(int IdCabinet) {
        String sql = "DELETE FROM Cabinet WHERE IdCabinet = ?";
        DatabaseConnection dbConn = new DatabaseConnection();
        Connection conn = dbConn.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, IdCabinet);
            pstmt.executeUpdate();
            System.out.println("Cabinetul cu IdCabinet-ul " + IdCabinet + " a fost șters din baza de date.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
    }
    public void printAll() {
        String sql = "SELECT * FROM Cabinet";
        DatabaseConnection dbConn = new DatabaseConnection();
        Connection conn = dbConn.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int idCabinet = rs.getInt("IdCabinet");
                String denumire = rs.getString("Denumire");
                int idPacient = rs.getInt("IdPacient");
                int idSpecializare = rs.getInt("IdSpecializare");
                int idProcedura = rs.getInt("IdProcedura");
                System.out.println("IdCabinet: " + idCabinet + ", Denumire: " + denumire + ", IdPacient: " + idPacient + ", IdSpecializare: " + idSpecializare + ", IdProcedura: " + idProcedura);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
    }

}

