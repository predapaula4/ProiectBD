package com.example.clinica;

import dtos.MaterialDTO;
import entities.Material;
import entities.Procedura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import services.MaterialServices;
import services.PacientServices;
import services.ProceduraServices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication(scanBasePackages = "com.example.clinica")
public class ClinicaApplication {

    @Autowired
    private final MaterialServices materialServices;

    @Autowired
    public ClinicaApplication(MaterialServices materialServices) {
        this.materialServices = materialServices;
    }

    public static void main(String[] args) {
        SpringApplication.run(ClinicaApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        List<Material> materials = materialServices.getAllMaterials();
        for (Material material : materials) {
            System.out.println(material);
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

