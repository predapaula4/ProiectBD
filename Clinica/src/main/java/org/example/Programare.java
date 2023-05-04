package org.example;

import lombok.Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class Programare {
    private int IdProgramare;
    private Pacient IdPacient;
    private Angajat IdAngajat;
    private Cabinet IdCabinet;
    private LocalDate DataConsultatie;
    private LocalTime OraConsultatiei;
    public Programare(Pacient IdPacient, Angajat IdAngajat, Cabinet IdCabinet, LocalDate DataConsultatie, LocalTime OraConsultatiei)
    {
        this.IdProgramare=0;
        this.IdPacient=IdPacient;
        this.IdAngajat=IdAngajat;
        this.IdCabinet=IdCabinet;
        this.DataConsultatie=DataConsultatie;
        this.OraConsultatiei=OraConsultatiei;
    }
    public Programare(int IdProgramare, Pacient IdPacient, Angajat IdAngajat, Cabinet IdCabinet, LocalDate DataConsultatie, LocalTime OraConsultatiei)
    {
        this.IdProgramare=IdProgramare;
        this.IdPacient=IdPacient;
        this.IdAngajat=IdAngajat;
        this.IdCabinet=IdCabinet;
        this.DataConsultatie=DataConsultatie;
        this.OraConsultatiei=OraConsultatiei;
    }
    public Programare(){

    }

    public Programare(int idProgramare) {
    }

    public void save() {
        String sql = "INSERT INTO Programare (IdPacient,IdAngajat, IdCabinet, DataConsultatie, OraConsultatiei) VALUES (?, ?)";
        DatabaseConnection dbConn = new DatabaseConnection();
        Connection conn = dbConn.getConnection();

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, IdPacient.getIdPacient());
            pstmt.setInt(2, IdAngajat.getIdAngajat());
            pstmt.setInt(3, IdCabinet.getIdCabinet());
            pstmt.setDate(4, java.sql.Date.valueOf(DataConsultatie));
            pstmt.setTime(5, java.sql.Time.valueOf(OraConsultatiei));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
    }
    public  void deleteById(int id) {
        String sql = "DELETE FROM Programare WHERE IdProgramare = ?";
        DatabaseConnection dbConn = new DatabaseConnection();
        Connection conn = dbConn.getConnection();

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Programarea cu id-ul " + id + " a fost ștearsă din baza de date.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
    }
    public void deleteByDataOra(LocalDate dataConsultatie, LocalTime oraConsultatiei) {
        String sql = "DELETE FROM Programare WHERE DataConsultatie = ? AND OraConsultatiei = ?";
        DatabaseConnection dbConn = new DatabaseConnection();
        Connection conn = dbConn.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDate(1, java.sql.Date.valueOf(dataConsultatie));
            pstmt.setTime(2, java.sql.Time.valueOf(oraConsultatiei));
            pstmt.executeUpdate();
            System.out.println("Programarea pentru data " + dataConsultatie + " si ora " + oraConsultatiei + " a fost stearsa din baza de date.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
    }

    public void printAll() {
        String sql = "SELECT * FROM Programare";
        DatabaseConnection dbConn = new DatabaseConnection();
        Connection conn = dbConn.getConnection();

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int idProgramare = rs.getInt("IdProgramare");
                int idPacient = rs.getInt("IdPacient");
                int idAngajat = rs.getInt("IdAngajat");
                int idCabinet = rs.getInt("IdCabinet");
                LocalDate dataConsultatie = rs.getDate("DataConsultatie").toLocalDate();
                LocalTime oraConsultatiei = rs.getTime("OraConsultatiei").toLocalTime();

                System.out.println("Id programare: " + idProgramare +
                        ", Id pacient: " + idPacient +
                        ", Id angajat: " + idAngajat +
                        ", Id cabinet: " + idCabinet +
                        ", Data consultatie: " + dataConsultatie +
                        ", Ora consultatie: " + oraConsultatiei);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
    }
    public Programare findById(int id) {
        String sql = "SELECT * FROM Programare WHERE IdProgramare = ?";
        DatabaseConnection dbConn = new DatabaseConnection();
        Connection conn = dbConn.getConnection();
        Programare programare = null;

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int idProgramare = rs.getInt("IdProgramare");
                int idPacient = rs.getInt("IdPacient");
                int idAngajat = rs.getInt("IdAngajat");
                int idCabinet = rs.getInt("IdCabinet");
                LocalDate dataConsultatie = rs.getDate("DataConsultatie").toLocalDate();
                LocalTime oraConsultatiei = rs.getTime("OraConsultatiei").toLocalTime();

                Pacient pacient = new Pacient().findById(idPacient);
                Angajat angajat = new Angajat().findById(idAngajat);
                Cabinet cabinet = new Cabinet().findById(idCabinet);
                programare = new Programare(idProgramare, pacient, angajat, cabinet, dataConsultatie, oraConsultatiei);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }

        return programare;
    }

}
