package com.example.clinica;

import dtos.AfectiuneDTO;
import dtos.AngajatDTO;
import dtos.MaterialDTO;
import entities.*;
import org.springframework.aop.aspectj.AspectJAdviceParameterNameDiscoverer;
import services.AfectiuneServices;
import services.AngajatServices;
import services.MaterialServices;
import services.ProceduraServices;

import java.util.List;
import java.util.Scanner;

public class Meniu {




//    //stergere
//    MaterialService materialService = new MaterialService();
//
//    // Creați un obiect Scanner pentru a citi de la tastatură
//    Scanner scanner = new Scanner(System.in);
//
//    // Citirea identificatorului materialului de la tastatură
//        System.out.print("Introduceți ID-ul materialului pe care doriți să-l ștergeți: ");
//    Long materialId = scanner.nextLong();
//
//    // Apelați metoda deleteMaterialById pentru a efectua ștergerea din tabel
//        materialService.deleteMaterialById(materialId);
//
//    // Închideți scannerul
//        scanner.close();

//    //update
//    // Creați o instanță a serviciului MaterialService
//    MaterialService materialService = new MaterialService();
//
//    // Creați un obiect Scanner pentru a citi de la tastatură
//    Scanner scanner = new Scanner(System.in);
//
//    // Citirea identificatorului materialului de la tastatură
//        System.out.print("Introduceți ID-ul materialului pe care doriți să-l actualizați: ");
//    Long materialId = scanner.nextLong();
//
//    // Citirea noilor valori ale câmpurilor materialului
//        System.out.print("Introduceți noua denumire a materialului: ");
//    String denumire = scanner.next();
//
//    // Creați o instanță a clasei MaterialDTO și setați noile valori ale câmpurilor
//    MaterialDTO materialDTO = new MaterialDTO();
//        materialDTO.setId(materialId);
//        materialDTO.setDenumire(denumire);
//
//    // Apelați metoda updateMaterial pentru a efectua actualizarea în tabel
//        materialService.updateMaterial(materialDTO);
//
//    // Închideți scannerul
//        scanner.close();

    public void alegeTabelInserare() {
        Scanner scanner = new Scanner(System.in);
        int optiune = 0;

        do {
            System.out.println("Tabelele pe care le puteti accesa sunt:");
            System.out.println("Pentru tabelul Afectiune apasati tasta 1");
            System.out.println("Pentru tabelul Angajat apasati tasta 2");
            System.out.println("Pentru tabelul Aparatura apasati tasta 3");
            System.out.println("Pentru tabelul Cabinet apasati tasta 4");
            System.out.println("Pentru tabelul Material apasati tasta 5");
            System.out.println("Pentru tabelul Pacient apasati tasta 6");
            System.out.println("Pentru tabelul Procedura apasati tasta 7");
            System.out.println("Pentru tabelul Programare apasati tasta 8");
            System.out.println("Pentru tabelul Specializare apasati tasta 9");
            System.out.println("Pentru a iesi din acest meniu si a va intoarce la meniul principal apasati tasta 10");
            System.out.print("Introduceti optiunea dorita: ");
            optiune = scanner.nextInt();
            switch (optiune) {
                case 1:
                    AfectiuneServices afectiuneService=new AfectiuneServices();
                    Scanner unu=new Scanner(System.in);
                    System.out.print("Introduceti denumirea afectiunii: ");
                    String denumireAfectiune = unu.nextLine();
                    //afisare proceduri
                    ProceduraServices proceduraServices=new ProceduraServices();
                    List<Procedura> proceduras = proceduraServices.getAllProceduras();
                    for (Procedura procedura1 : proceduras) {
                        System.out.println(procedura1);
                    }
                    System.out.print("Introduceti denumirea id-ul procedurii, puteti alege din procedurile de mai sus: ");
                    int idProceduraAfectiune = unu.nextInt();
                    AfectiuneDTO afectiuneDTO=new AfectiuneDTO();
                    afectiuneDTO.setDenumire(denumireAfectiune);
                    afectiuneDTO.setIdProcedura(idProceduraAfectiune);
                    afectiuneService.createAfectiune(afectiuneDTO);
                    //afisare afectiuni
                    List<Afectiune> afectiune = afectiuneService.gelAllAfections();
                    for (Afectiune afectiune1 : afectiune) {
                        System.out.println(afectiune1);
                    }
                    unu.close();
                    break;
                case 2:
                    AngajatServices angajatServices=new AngajatServices();
                    Scanner doi=new Scanner(System.in);
                    System.out.println("Introduceti Numele angajatului: ");
                    String numeAngajat=doi.nextLine();
                    System.out.println("Introduceti prenumele angajatului: ");
                    String prenumeAngajat=doi.nextLine();
                    System.out.println("Introduceti salariul angajatului: ");
                    Integer salariuAngajat=doi.nextInt();
                    AngajatDTO angajatDTO=new AngajatDTO();
                    angajatDTO.setNume(numeAngajat);
                    angajatDTO.setPrenume(prenumeAngajat);
                    angajatDTO.setSalariu(salariuAngajat);
                    angajatServices.createAngajat(angajatDTO);
                    List<Angajat> angajats = angajatServices.getAllAngajats();
                    for (Angajat angajat : angajats) {
                        System.out.println(angajat);
                    }
                    doi.close();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    //inserare
                    MaterialServices materialService = new MaterialServices();
                    Scanner cinci = new Scanner(System.in);
                    System.out.print("Introduceti denumirea materialului: ");
                    String denumireMaterial = cinci.nextLine();
                    MaterialDTO materialDTO = new MaterialDTO();
                    materialDTO.setDenumire(denumireMaterial);
                    materialService.createMaterial(materialDTO);
                    List<Material> materials = materialService.getAllMaterials();
                    for (Material material : materials) {
                        System.out.println("ID: " + material.getIdMaterial());
                        System.out.println("Denumire: " + material.getDenumire());
                        System.out.println("----------------------");
                    }
                    cinci.close();
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:

                    break;
                case 10:
                    meniuPrincipal();
                    break;
                default:
                    System.out.println("Optiunea introdusa este invalida. Va rugam sa incercati din nou.");
                    break;
            }
        } while (optiune != 10);
    }
    public void meniuPrincipal() {
        Scanner scanner2 = new Scanner(System.in);
        int optiune2 = 0;

        do {

            System.out.println("Pentru inserarea datelor intr un tabel apasati tasta 1");
            System.out.println("Pentru stergerea datelor dintr un tabel in functie de denumire/nume, prenume apasati tasta 2");
            System.out.println("Pentru stergerea datelor dintr un tabel in functie de id apasati tasta 3");
            System.out.println("Pentru a modifica date dintr un tabel apasati tasta 4");
            System.out.println("Pentru a iesi apasati tasta 5");

            System.out.print("Introduceti optiunea dorita: ");
            optiune2 = scanner2.nextInt();

            switch (optiune2) {
                case 1:
                    System.out.println("Ati selectat optiunea 1.");
                    System.out.println("Alegeti tabelul in care doriti sa inserati: ");
                    alegeTabelInserare();
                    break;
                case 2:
                    System.out.println("Ati selectat optiunea 2.");
                    System.out.println("Alegeti tabelul din care doriti sa stergeti: ");
                    //alegeTabelStergereDenumire();
                    break;
                case 3:
                    System.out.println("Ati selectat optiunea 3.");
                    System.out.println("Alegeti tabelul din care doriti sa stergeti: ");
                    //alegeTabelStergereId();
                    break;
                case 4:
                    System.out.println("Ati selectat optiunea 4.");
                    System.out.println("Alegeti tabelul in care doriti sa modificati: ");
                    //alegeTabelUpdate();
                    break;
                case 5:
                    System.out.println("La revedere!");
                default:
                    System.out.println("Optiunea introdusa este invalida. Va rugam sa incercati din nou.");
                    break;
            }
        } while (optiune2 != 5);

        scanner2.close();
    }


}


