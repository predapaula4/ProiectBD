package org.example;

import lombok.Data;

import java.sql.*;

@Data
public class Pacient {
    private int IdPacient;
    private Afectiune IdAfectiune;
    private Programare IdProgramare;
    private String Nume;
    private String Prenume;
    private int Varsta;
    Pacient(Afectiune idAfectiune, Programare IdProgramare, String Nume, String Prenume, int Varsta)
    {
        this.IdPacient=0;
        this.IdAfectiune=IdAfectiune;
        this.IdProgramare=IdProgramare;
        this.Nume=Nume;
        this.Prenume=Prenume;
        this.Varsta=Varsta;
    }
    Pacient(int IdPacient, Afectiune idAfectiune, Programare IdProgramare, String Nume, String Prenume, int Varsta)
    {
        this.IdPacient=IdPacient;
        this.IdAfectiune=IdAfectiune;
        this.IdProgramare=IdProgramare;
        this.Nume=Nume;
        this.Prenume=Prenume;
        this.Varsta=Varsta;
    }
    public Pacient(){

    }

    public Pacient(int idPacient) {
    }

    public void save() {
        String sql = "INSERT INTO Programare (IdAfectiune, IdProgramare, Nume, Prenume, Varsta) VALUES (?,?,?,?, ?)";
        DatabaseConnection dbConn = new DatabaseConnection();
        Connection conn = dbConn.getConnection();

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, IdAfectiune.getIdAfectiune());
            pstmt.setInt(2, IdProgramare.getIdProgramare());
            pstmt.setString(3,Nume);
            pstmt.setString(4,Prenume);
            pstmt.setInt(5, Varsta);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
    }
    public void deleteAllByNP(String nume, String prenume) {
        String sql = "DELETE FROM Pacient WHERE Nume = ? AND Prenume = ?";
        DatabaseConnection dbConn = new DatabaseConnection();
        Connection conn = dbConn.getConnection();

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nume);
            pstmt.setString(2, prenume);
            pstmt.executeUpdate();
            System.out.println("Pacientul cu numele" + nume+" si prenumele "+prenume + " a fost ștears din baza de date.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
    }
    public  void deleteById(int id) {
        String sql = "DELETE FROM Pacient WHERE IdPacient = ?";
        DatabaseConnection dbConn = new DatabaseConnection();
        Connection conn = dbConn.getConnection();

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Pacientul cu id-ul " + id + " a fost șters din baza de date.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
    }
    public void printAll() {
        String sql = "SELECT * FROM Pacient";
        DatabaseConnection dbConn = new DatabaseConnection();
        Connection conn = dbConn.getConnection();

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int idPacient = rs.getInt("IdPacient");
                int idAfectiune = rs.getInt("IdAfectiune");
                int idProgramare = rs.getInt("IdProgramare");
                String nume = rs.getString("Nume");
                String prenume = rs.getString("Prenume");
                int varsta = rs.getInt("Varsta");
                System.out.println("IdPacient: " + idPacient + " | IdAfectiune: " + idAfectiune +
                        " | IdProgramare: " + idProgramare + " | Nume: " + nume +
                        " | Prenume: " + prenume + " | Varsta: " + varsta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
    }
    public Pacient findById(int id) {
        String sql = "SELECT * FROM Pacient WHERE IdPacient = ?";
        DatabaseConnection dbConn = new DatabaseConnection();
        Connection conn = dbConn.getConnection();

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int idPacient = rs.getInt("IdPacient");
                int idAfectiune = rs.getInt("IdAfectiune");
                int idProgramare = rs.getInt("IdProgramare");
                String nume = rs.getString("Nume");
                String prenume = rs.getString("Prenume");
                int varsta = rs.getInt("Varsta");
                return new Pacient(idPacient, new Afectiune(idAfectiune), new Programare(idProgramare), nume, prenume, varsta);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
        return null;
    }


}
