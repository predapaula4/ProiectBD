package com.example.clinica;

import com.example.clinica.dtos.MaterialDTO;
import com.example.clinica.entities.Material;
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
            System.out.println("Alegeti o optiune:");
            System.out.println("1. Aduagare material");
            System.out.println("2. Cautare material dupa ID");
            System.out.println("3. Stergere material dupa ID");
            System.out.println("4. Actualizare material");
            System.out.println("5. Afisati toate materialele");
            System.out.println("6. Cautare material dupa denumire");
            System.out.println("7. Stergere material dupa denumire");
            System.out.println("8. Iesire");


            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    // Add material
                    MaterialDTO materialDTO = new MaterialDTO();
                    System.out.print("Introduceti denumirea: ");
                    String denumire = scanner.nextLine();
                    materialDTO.setDenumire(denumire);
                    materialServices.createMaterial(materialDTO);
                    break;
                case 2:
                    // Get material by ID
                    System.out.print("Introduceti id-ul materialului: ");
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
                    System.out.println(materialServices.getAllMaterials());
                    System.out.print("Introduceti id-ul materialului de actualizat: ");
                    id = scanner.nextLong();
                    System.out.print("Introduceti noua denumire: ");
                    denumire = scanner.next();
                    materialServices.updateMaterial(id, denumire);
                    break;
                case 5:
                    // List all materials
                    System.out.println(materialServices.getAllMaterials());
                    break;
                case 6:
                    // Get material by denumire
                    System.out.print("Introduceti denumirea materialului: ");
                    denumire = scanner.nextLine();
                    Material material = materialServices.getMaterialByDenumire(denumire);
                    if (material != null) {
                        System.out.println(material);
                    } else {
                        System.out.println("Materialul cu denumirea " + denumire + " nu a fost gasit.");
                    }
                    break;
                case 7:
                    // Delete material by denumire
                    System.out.print("Introduceti denumirea materialului de sters: ");
                    denumire = scanner.nextLine();
                    materialServices.deleteMaterialByDenumire(denumire);
                    break;
                case 8:
                    System.out.println("Iesire din aplicatie.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Optiune invalida.");
            }
        }
    }
}

//       Meniu meniu=new Meniu();
//       meniu.meniuPrincipal();


