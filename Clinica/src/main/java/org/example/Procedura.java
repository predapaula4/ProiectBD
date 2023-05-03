package org.example;

import lombok.Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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


}
