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
    Meniu meniu=new Meniu(context);
    meniu.meniuPrincipal();

//        MaterialServices materialServices = context.getBean(MaterialServices.class);
//
//        Scanner scanner = new Scanner(System.in);
//
//        while (true) {
//            System.out.println("Alegeti o optiune:");
//            System.out.println("1. Aduagare material");
//            System.out.println("2. Cautare material dupa ID");
//            System.out.println("3. Stergere material dupa ID");
//            System.out.println("4. Actualizare material");
//            System.out.println("5. Afisati toate materialele");
//            System.out.println("6. Cautare material dupa denumire");
//            System.out.println("7. Stergere material dupa denumire");
//            System.out.println("8. Iesire");
//
//
//            int option = scanner.nextInt();
//            scanner.nextLine();
//
//
//                case 6:
//                    // Get material by denumire
//                    System.out.print("Introduceti denumirea materialului: ");
//                    denumire = scanner.nextLine();
//                    Material material = materialServices.getMaterialByDenumire(denumire);
//                    if (material != null) {
//                        System.out.println(material);
//                    } else {
//                        System.out.println("Materialul cu denumirea " + denumire + " nu a fost gasit.");
//                    }
//                    break;
//                case 7:
//                    // Delete material by denumire
//                    System.out.print("Introduceti denumirea materialului de sters: ");
//                    denumire = scanner.nextLine();
//                    materialServices.deleteMaterialByDenumire(denumire);
//                    break;
//
//        }

    }
}




