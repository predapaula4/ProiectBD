package com.example.clinica;

import dtos.MaterialDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import services.MaterialServices;

import java.util.Scanner;

@SpringBootApplication
public class ClinicaApplication {

    public static void main(String[] args) {
       Meniu meniu=new Meniu();
       meniu.meniuPrincipal();
    }

}
