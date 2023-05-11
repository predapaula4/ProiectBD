package com.example.clinica;

import dtos.MaterialDTO;
import entities.Procedura;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import services.MaterialServices;
import services.PacientServices;
import services.ProceduraServices;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class ClinicaApplication {

    public static void main(String[] args) {
//       Meniu meniu=new Meniu();
//       meniu.meniuPrincipal();
        ProceduraServices proceduraServices=new ProceduraServices();
        List<Procedura> proceduras = proceduraServices.getAllProceduras();
        for (Procedura procedura1 : proceduras) {
            System.out.println(procedura1);
        }
    }

}
