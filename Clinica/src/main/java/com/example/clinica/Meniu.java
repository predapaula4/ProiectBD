package com.example.clinica;

//import com.example.clinica.dtos.*;
//import com.example.clinica.entities.*;
//import com.example.clinica.services.*;

import com.example.clinica.dtos.AfectiuneDTO;
import com.example.clinica.entities.*;
import com.example.clinica.services.AfectiuneServices;
import com.example.clinica.dtos.ProceduraDTO;
import com.example.clinica.services.ProceduraServices;
import com.example.clinica.dtos.AngajatDTO;
import com.example.clinica.services.AngajatServices;
import com.example.clinica.dtos.AparaturaDTO;
import com.example.clinica.services.AparaturaServices;
import com.example.clinica.dtos.MaterialDTO;
import com.example.clinica.services.MaterialServices;
import com.example.clinica.dtos.PacientDTO;
import com.example.clinica.services.PacientServices;

// ... import other classes you need explicitly

import java.util.List;
import java.util.Scanner;

public class Meniu {

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
            System.out.println("Pentru tabelul Material apasati tasta 4");
            System.out.println("Pentru tabelul Pacient apasati tasta 5");
            System.out.println("Pentru tabelul Procedura apasati tasta 6");
            System.out.println("Pentru tabelul Programare apasati tasta 7");
            System.out.println("Pentru tabelul Specializare apasati tasta 8");
            System.out.println("Pentru a iesi din acest meniu si a va intoarce la meniul principal apasati tasta 10");
            System.out.print("Introduceti optiunea dorita: ");
            optiune = scanner.nextInt();
            switch (optiune) {
                case 1:
                    AfectiuneServices afectiuneService = new AfectiuneServices();
                    Scanner unu = new Scanner(System.in);
                    System.out.print("Introduceti denumirea afectiunii: ");
                    String denumireAfectiune = unu.nextLine();
                    //afisare proceduri
                    ProceduraServices proceduraServices = new ProceduraServices();
                    List<Procedura> proceduras = proceduraServices.getAllProceduras();
                    for (Procedura procedura1 : proceduras) {
                        System.out.println(procedura1);
                    }
                    System.out.print("Introduceti denumirea id-ul procedurii, puteti alege din procedurile de mai sus: ");
                    int idProceduraAfectiune = unu.nextInt();
                    AfectiuneDTO afectiuneDTO = new AfectiuneDTO();
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
                    AngajatServices angajatServices = new AngajatServices();
                    Scanner doi = new Scanner(System.in);
                    System.out.println("Introduceti Numele angajatului: ");
                    String numeAngajat = doi.nextLine();
                    System.out.println("Introduceti prenumele angajatului: ");
                    String prenumeAngajat = doi.nextLine();
                    System.out.println("Introduceti salariul angajatului: ");
                    Integer salariuAngajat = doi.nextInt();
                    AngajatDTO angajatDTO = new AngajatDTO();
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
                    AparaturaServices aparaturaServices = new AparaturaServices();
                    Scanner trei = new Scanner(System.in);
                    System.out.println("Introduceti denumirea materialului: ");
                    String denumireAparatura = trei.nextLine();
                    AparaturaDTO aparaturaDTO = new AparaturaDTO();
                    aparaturaDTO.setDenumire(denumireAparatura);
                    aparaturaServices.createAparatura(aparaturaDTO);
                    List<Aparatura> aparaturas = aparaturaServices.getAllAparaturas();
                    for (Aparatura aparatura : aparaturas)
                        System.out.println(aparatura);
                    break;
                case 4:
                    //inserare
                    MaterialServices materialService = new MaterialServices();
                    Scanner patru = new Scanner(System.in);
                    System.out.print("Introduceti denumirea materialului: ");
                    String denumireMaterial = patru.nextLine();
                    MaterialDTO materialDTO = new MaterialDTO();
                    materialDTO.setDenumire(denumireMaterial);
                    materialService.createMaterial(materialDTO);
                    List<Material> materials = materialService.getAllMaterials();
                    for (Material material : materials) {
                        System.out.println(material);
                    }
                    patru.close();
                    break;
                    case 5:
                            PacientServices pacientServices = new PacientServices();
                            Scanner cinci = new Scanner(System.in);
                            AfectiuneServices afectiuneServices=new AfectiuneServices();
                            List<Afectiune> afectiunes = afectiuneServices.gelAllAfections();
                            for (Afectiune afectiune1 : afectiunes)
                                System.out.println(afectiune1);
                            System.out.println("Introduceti id-ul afectiuni, puteti alege din afectiunile de mai sus");
                            Integer idAfectiunePacient = cinci.nextInt();
//                    ProgramareServices programareServices=new ProgramareServices();
//                    List<Programare> programares=programareServices.getAllProgramare();
//                    for(Programare programare:programares)
//                        System.out.println(programare);
                            //trebuie creata o programare noua

                            System.out.println("Introduceti numele pacientului: ");
                            String numePacient = cinci.nextLine();
                            System.out.println("Introduceti prenumele pacientului: ");
                            String prenumePacient = cinci.nextLine();
                            System.out.println("Introduceti varsta pacientului: ");
                            Integer varstaPacient = cinci.nextInt();
                        PacientDTO pacientDTO=new PacientDTO();
                        pacientDTO.setIdAfectiune(idAfectiunePacient);
                        pacientDTO.setNume(numePacient);
                        pacientDTO.setPrenume(prenumePacient);
                        pacientDTO.setVarsta(varstaPacient);
                        pacientServices.createPacient(pacientDTO);
                        List<Pacient> pacients=pacientServices.getAllPacients();
                        for(Pacient pacient:pacients)
                        {
                            System.out.println(pacient);
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
                            meniuPrincipal();
                            break;
                        default:
                            System.out.println("Optiunea introdusa este invalida. Va rugam sa incercati din nou.");
                            break;
                    }

        } while (optiune != 9);
    scanner.close();
    }
    public void alegeTabelStergere() {
        Scanner scanner = new Scanner(System.in);
        int optiune = 0;

        do {
            System.out.println("Tabelele pe care le puteti accesa sunt:");
            System.out.println("Pentru tabelul Afectiune apasati tasta 1");
            System.out.println("Pentru tabelul Angajat apasati tasta 2");
            System.out.println("Pentru tabelul Aparatura apasati tasta 3");
            System.out.println("Pentru tabelul Material apasati tasta 4");
            System.out.println("Pentru tabelul Pacient apasati tasta 5");
            System.out.println("Pentru tabelul Procedura apasati tasta 6");
            System.out.println("Pentru tabelul Programare apasati tasta 7");
            System.out.println("Pentru tabelul Specializare apasati tasta 8");
            System.out.println("Pentru a iesi din acest meniu si a va intoarce la meniul principal apasati tasta 10");
            System.out.print("Introduceti optiunea dorita: ");
            optiune = scanner.nextInt();
            switch (optiune) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    MaterialServices materialService = new MaterialServices();
                    Scanner patru = new Scanner(System.in);
//                    List<Material> materials = materialService.getAllMaterials();
//                    for (Material material : materials) {
//                        System.out.println(material);
//                    }
                    System.out.print("Introduceți ID-ul materialului pe care doriți sa-l stergeti: ");
                    Long materialId = patru.nextLong();
                    materialService.deleteMaterialById(materialId);
                    scanner.close();
                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    meniuPrincipal();
                    break;
                default:
                    System.out.println("Optiunea introdusa este invalida. Va rugam sa incercati din nou.");
                    break;
            }

        } while (optiune != 9);
        scanner.close();
    }
    public void meniuPrincipal() {
        Scanner scanner2 = new Scanner(System.in);
        int optiune2 = 0;

        do {

            System.out.println("Pentru inserarea datelor intr un tabel apasati tasta 1");
            System.out.println("Pentru stergerea datelor dintr un tabel in functie de id apasati tasta 2");
            System.out.println("Pentru a modifica date dintr un tabel apasati tasta 3");
            System.out.println("Pentru a iesi apasati tasta 4");
            System.out.print("Introduceti optiunea dorita: ");
            optiune2 = scanner2.nextInt();

            switch (optiune2) {
                case 1:
                    System.out.println("Ati selectat optiunea 1.");
                    System.out.println("Alegeti tabelul in care doriti sa inserati: ");
                    alegeTabelInserare();
                    break;
                case 2:
                    System.out.println("Ati selectat optiunea 3.");
                    System.out.println("Alegeti tabelul din care doriti sa stergeti: ");
                    alegeTabelStergere();
                    break;
                case 3:
                    System.out.println("Ati selectat optiunea 4.");
                    System.out.println("Alegeti tabelul in care doriti sa modificati: ");
                    //alegeTabelUpdate();
                    break;
                case 4:
                    System.out.println("La revedere!");
                    break;
                default:
                    System.out.println("Optiunea introdusa este invalida. Va rugam sa incercati din nou.");
                    break;
            }
        } while (optiune2 != 4);

        scanner2.close();
    }


}


