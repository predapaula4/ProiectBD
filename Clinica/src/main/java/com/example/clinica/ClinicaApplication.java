package com.example.clinica;

import com.example.clinica.dtos.MaterialDTO;
import com.example.clinica.services.MaterialServices;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

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

        MaterialServices materialServices = context.getBean(MaterialServices.class);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Add material");
            System.out.println("2. Get material by ID");
            System.out.println("3. Delete material by ID");
            System.out.println("4. Update material");
            System.out.println("5. List all materials");
            System.out.println("6. Exit");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    // Add material
                    MaterialDTO materialDTO = new MaterialDTO();
                    System.out.print("Enter denumire: ");
                    materialDTO.setDenumire(scanner.next());
                    materialServices.createMaterial(materialDTO);
                    break;
                case 2:
                    // Get material by ID
                    System.out.print("Enter Material ID: ");
                    Long id = scanner.nextLong();
                    System.out.println(materialServices.getMaterialById(id));
                    break;
                case 3:
                    // Delete material by ID
                    System.out.print("Enter Material ID to delete: ");
                    id = scanner.nextLong();
                    materialServices.deleteMaterialById(id);
                    break;
                case 4:
                    // Update material
                    System.out.print("Enter Material ID to update: ");
                    id = scanner.nextLong();
                    System.out.print("Enter new denumire: ");
                    String denumire = scanner.next();
                    materialServices.updateMaterial(id, denumire);
                    break;
                case 5:
                    // List all materials
                    System.out.println(materialServices.getAllMaterials());
                    break;
                case 6:
                    System.out.println("Exiting the application.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

//       Meniu meniu=new Meniu();
//       meniu.meniuPrincipal();


