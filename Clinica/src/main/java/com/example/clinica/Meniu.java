package com.example.clinica;

//import com.example.clinica.dtos.*;
//import com.example.clinica.entities.*;
//import com.example.clinica.services.*;

import com.example.clinica.dtos.*;
import com.example.clinica.entities.*;
import com.example.clinica.services.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

// ... import other classes you need explicitly

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Meniu {

    private ConfigurableApplicationContext context;

    public Meniu(ConfigurableApplicationContext context) {
        this.context = context;
    }
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
                    AfectiuneServices afectiuneServices=context.getBean(AfectiuneServices.class);
                    AfectiuneDTO afectiuneDTO= new AfectiuneDTO();
                    System.out.println("Introduceti denumirea: ");
                    String denumireAfectiune=scanner.nextLine();
                    afectiuneDTO.setDenumire(denumireAfectiune);
                    ProceduraServices proceduraServices=context.getBean(ProceduraServices.class);
                    System.out.println(proceduraServices.getAllProceduras());
                    System.out.println("Introduceti id-ul procedurii, puteti selecta din cele de mai sus: ");
                    Integer idProceduraAfectiune=scanner.nextInt();
                    afectiuneDTO.setIdProcedura(idProceduraAfectiune);
                    afectiuneServices.createAfectiune(afectiuneDTO);
                    System.out.println(afectiuneServices.gelAllAfections());
                    break;
                case 2:
                    AngajatServices angajatServices=context.getBean(AngajatServices.class);
                    AngajatDTO angajatDTO=new AngajatDTO();
                    SpecializareServices specializareServices=context.getBean(SpecializareServices.class);
                    System.out.println(specializareServices.getAllSpecializares());
                    System.out.println("Introduceti id-ul specializarii, puteti introduce din cele de mai sus: ");
                    Long idSpecializareAngajat= scanner.nextLong();
                    angajatDTO.setIdSpecializare(idSpecializareAngajat);
                    System.out.println("Introduceti numele angajatului: ");
                    String numeAngajat=scanner.nextLine();
                    angajatDTO.setNume(numeAngajat);
                    System.out.println("Introduceti prenumele angajatului: ");
                    String prenumeAngajat=scanner.nextLine();
                    angajatDTO.setPrenume(prenumeAngajat);
                    System.out.println("Introduceti salariul angajatului: ");
                    Integer salariuAngajat= scanner.nextInt();
                    angajatDTO.setSalariu(salariuAngajat);
                    angajatServices.createAngajat(angajatDTO);
                    System.out.println(angajatServices.getAllAngajats());
                    break;
                case 3:
                    AparaturaServices aparaturaServices=context.getBean(AparaturaServices.class);
                    AparaturaDTO aparaturaDTO=new AparaturaDTO();
                    System.out.println("Introduceti denumirea: ");
                    String denumireAparatura=scanner.nextLine();
                    aparaturaDTO.setDenumire(denumireAparatura);
                    aparaturaServices.createAparatura(aparaturaDTO);
                    System.out.println(aparaturaServices.getAllAparaturas());
                    break;
                case 4:
                    MaterialServices materialServices = context.getBean(MaterialServices.class);
                    MaterialDTO materialDTO = new MaterialDTO();
                    System.out.print("Introduceti denumirea: ");
                    String denumireMaterial = scanner.nextLine();
                    materialDTO.setDenumire(denumireMaterial);
                    materialServices.createMaterial(materialDTO);
                    System.out.println(materialServices.getAllMaterials());
                    break;
                case 5:
                    // id afec id pogramare nume prenume varsta
                    PacientServices pacientServices=context.getBean(PacientServices.class);
                    AfectiuneServices afectiuneServices1=context.getBean(AfectiuneServices.class);
                    PacientDTO pacientDTO=new PacientDTO();
                    System.out.println(afectiuneServices1.gelAllAfections());
                    System.out.println("Introduceti id-ul afectiunii, puteti alege din afectiunile de mai sus: ");
                    Integer idAfectiunePacient=scanner.nextInt();
                    pacientDTO.setIdAfectiune(idAfectiunePacient);
                    //...
                    break;
                case 6:
                    ProceduraServices proceduraServices1=context.getBean(ProceduraServices.class);
                    ProceduraDTO proceduraDTO=new ProceduraDTO();
                    System.out.println("Introduceti denumire: ");
                    String denumireProcedura=scanner.nextLine();
                    proceduraDTO.setDenumire(denumireProcedura);
                    AfectiuneServices afectiuneServices2=context.getBean(AfectiuneServices.class);
                    System.out.println(afectiuneServices2.gelAllAfections());
                    System.out.println("Introduceti id-ul afectiunii, puteti alege din afectiunile de mai sus: ");
                    Integer idAfectiuneProcedura=scanner.nextInt();
                    proceduraDTO.setIdAfectiune(idAfectiuneProcedura);
                    AparaturaServices aparaturaServices1=context.getBean(AparaturaServices.class);
                    System.out.println(aparaturaServices1.getAllAparaturas());
                    System.out.println("Introduceti id-ul aparaturii, puteti alege din aparaturile de mai sus: ");
                    Integer idAparaturaProcedura= scanner.nextInt();
                    proceduraDTO.setIdAparatura(idAparaturaProcedura);
                    MaterialServices materialServices1=context.getBean(MaterialServices.class);
                    System.out.println(materialServices1.getAllMaterials());
                    System.out.println("Introduceti id-ul materialului, puteti alege din materialele de mai sus: ");
                    Integer idMaterialProcedura= scanner.nextInt();
                    proceduraDTO.setIdMaterial(idMaterialProcedura);
                    proceduraServices1.createProcedura(proceduraDTO);
                    System.out.println(proceduraServices1.getAllProceduras());
                    break;
                case 7:
                    ProgramareServices programareServices=context.getBean(ProgramareServices.class);
                    ProgramareDTO programareDTO=new ProgramareDTO();
                    PacientServices pacientServices2=context.getBean(PacientServices.class);
                    System.out.println(pacientServices2.getAllPacients());
                    System.out.println("Introduceti id-ul pacientului, puteti alege din pacienti de mai sus: ");
                    Integer idPacientProgramare=scanner.nextInt();
                    programareDTO.setIdPacient(idPacientProgramare);
                    AngajatServices angajatServices1=context.getBean(AngajatServices.class);
                    System.out.println(angajatServices1.getAllAngajats());
                    System.out.println("Introduceti id-ul angajatului, puteti alege din angajatii de mai sus: ");
                    Integer idAngajatProgramare= scanner.nextInt();
                    programareDTO.setIdAngajat(idAngajatProgramare);
                    System.out.println("Introduceti data la care doriti sa fiti programat (yyyy-MM-dd): ");
                    String dataString = scanner.nextLine();
                    // Specificați formatul dorit pentru data
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    // Parsați șirul într-un obiect de tip LocalDate
                    LocalDate data = LocalDate.parse(dataString, formatter);
                    programareDTO.setDataConsultatie(data);
                    System.out.println("Introduceti ora la care doriti sa fiti programat (HH:mm:ss): ");
                    String oraString = scanner.nextLine();
                    // Specificați formatul dorit pentru ora
                    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm:ss");
                    // Parsați șirul într-un obiect de tip LocalTime
                    LocalTime ora = LocalTime.parse(oraString, formatter2);
                    programareDTO.setOraConsultatiei(ora);
                    programareServices.createProgramare(programareDTO);
                    System.out.println(programareServices.getAllProgramare());
                    break;
                case 8:
                    //denumire
                    SpecializareServices specializareServices1=context.getBean(SpecializareServices.class);
                    SpecializareDTO specializareDTO=new SpecializareDTO();
                    System.out.println("Introduceti denumirea: ");
                    String denumireSpecializare=scanner.nextLine();
                    specializareDTO.setDenumire(denumireSpecializare);
                    specializareServices1.createSpecializare(specializareDTO);
                    System.out.println(specializareServices1.getAllSpecializares());
                    break;
                case 9:
                    meniuPrincipal();
                    break;
                default :
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
                    AfectiuneServices afectiuneServices=context.getBean(AfectiuneServices.class);
                    System.out.println(afectiuneServices.gelAllAfections());
                    System.out.println("Introduceti id-l afectiunii, puteti alege din afectiunile de mai sus:");
                    Long idAfectiune=scanner.nextLong();
                    afectiuneServices.deleteAfectiuneById(idAfectiune);
                    System.out.println(afectiuneServices.gelAllAfections());
                    break;
                case 2:
                    AngajatServices angajatServices=context.getBean(AngajatServices.class);
                    System.out.println(angajatServices.getAllAngajats());
                    System.out.println();
                    System.out.print("Introduceti id-ul angajatului, putei alege din angajatii de mai sus: ");
                    Long idAngajat = scanner.nextLong();
                    angajatServices.deleteAngajatById(idAngajat);
                    System.out.println(angajatServices.getAllAngajats());
                    break;
                case 3:

                    break;
                case 4:
                    MaterialServices materialServices=context.getBean(MaterialServices.class);
                    System.out.println(materialServices.getAllMaterials());
                    System.out.print("Introduceti id-ul materialului, putei alege din materialele de mai sus: ");
                    Long idMaterial = scanner.nextLong();
                    materialServices.deleteMaterialById(idMaterial);
                    System.out.println(materialServices.getAllMaterials());
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


