package com.example.clinica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
public class ClinicaApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ClinicaApplication.class, args);

        DataSource dataSource = context.getBean(DataSource.class);

        try (Connection connection = dataSource.getConnection()) {
            System.out.println("Connected to database: " + connection.getCatalog());
        } catch (SQLException ex) {
            System.out.println("Connection failed");
            ex.printStackTrace();
        }
    }
}
//       Meniu meniu=new Meniu();
//       meniu.meniuPrincipal();
//        ProceduraServices proceduraServices=new ProceduraServices();
//        List<Procedura> proceduras = proceduraServices.getAllProceduras();
//        for (Procedura procedura1 : proceduras) {
//            System.out.println(procedura1);
//        }

//        String url = "jdbc:postgresql://localhost:5432/ClinicaRecuperareV2?currentSchema=public";
//        String username = "postgres";
//        String password = "1234";
//
//        try {
//            Connection connection = DriverManager.getConnection(url, username, password);
//            System.out.println("Conexiunea la baza de date PostgreSQL a fost stabilită cu succes!");
//            //Aici puteți executa interogări sau acțiuni suplimentare pe baza de date
//            MaterialServices materialServices = new MaterialServices();
//            List<Material> materials = materialServices.getAllMaterials();
//            for (Material material : materials) {
//                System.out.println(material);
//            }
//            // Închideți conexiunea la finalul procesului
//            //connection.close();
//        } catch (SQLException e) {
//            System.out.println("A apărut o eroare la conectarea la baza de date PostgreSQL: " + e.getMessage());
//        }

