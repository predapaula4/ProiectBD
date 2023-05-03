package org.example;

import lombok.Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
    public void save() {
        String sql = "INSERT INTO Programare (IdPacient,IdAngajat, IdCabinet, DataConsultatie, OraConsultatiei) VALUES (?, ?)";
        DatabaseConnection dbConn = new DatabaseConnection();
        Connection conn = dbConn.getConnection();

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, IdPacient.getIdPacient());
            pstmt.setInt(2, IdAngajat.getIdAngajat());
            pstmt.setInt(3,IdCabinet.getIdCabinet());
            pstmt.setDate(4, java.sql.Date.valueOf(DataConsultatie));
            pstmt.setTime(5, java.sql.Time.valueOf(OraConsultatiei));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }
    }


}
