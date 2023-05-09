package com.example.clinicarecuperare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClinicaRecuperareApplication {

    public static void main(String[] args) {
        Specializare specializare = new Specializare("Denumire specializare");
        specializare.adaugaSpecializare();
    }

}
