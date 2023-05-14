package com.example.clinica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
@SpringBootApplication
public class ClinicaApplication
{
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ClinicaApplication.class, args);
        DataSource dataSource = context.getBean(DataSource.class);
        try (Connection connection = dataSource.getConnection()) {
            System.out.println("Connected to database: " + connection.getCatalog());
        } catch (SQLException ex) {
            System.out.println("Connection failed");
            ex.printStackTrace();
        }
    Meniu meniu=new Meniu(context);
    meniu.meniuPrincipal();
    }
}




