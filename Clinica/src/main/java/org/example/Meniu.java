package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Meniu
{
    public void alegeTabelInserare() {
        Scanner scanner = new Scanner(System.in);
        int optiune = 0;

        do {
            System.out.println("Tabelele pe care le puteti accesa sunt:");
            System.out.println("Pentru tabelul Afectiune 1");
            System.out.println("Pentru tabelul Angajat 2");
            System.out.println("Pentru tabelul Aparatura 3");
            System.out.println("Pentru tabelul Cabinet 4");
            System.out.println("Pentru tabelul Material 5");
            System.out.println("Pentru tabelul Pacient 6");
            System.out.println("Pentru tabelul Procedura 7");
            System.out.println("Pentru tabelul Programare 8");
            System.out.println("Pentru tabelul Specializare 9");
            System.out.println("Pentru a iesi din acest meniu si a va intoarce la meniul principal apasati tasta 10");
            System.out.print("Introduceti optiunea dorita: ");
            optiune = scanner.nextInt();
            switch (optiune) {
                case 1:
                    System.out.println("Introduceti denumirea afectiuni:");
                    Scanner unu = new Scanner(System.in);
                    String optiunea1= unu.nextLine();
                    Procedura procedura=new Procedura();
                    procedura.printAll();
                    System.out.println("Introduceti id-ul Procedurii, puteti alege din procedurile de mai sus ");
                    int optiune1=unu.nextInt();
                    Afectiune afectiune=new Afectiune(optiunea1, procedura.findById(optiune1));
                    afectiune.printAll();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
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


    public void alegeTabelStergereDenumire() {
        Scanner scanner3 = new Scanner(System.in);
        int optiune3 = 0;

        do {
            System.out.println("Tabelele pe care le puteti accesa sunt:");
            System.out.println("Pentru tabelul Afectiune tasta 1");
            System.out.println("Pentru tabelul Angajat tasta 2");
            System.out.println("Pentru tabelul Aparatura tasta 3");
            System.out.println("Pentru tabelul Cabinet tasta 4");
            System.out.println("Pentru tabelul Material tasta 5");
            System.out.println("Pentru tabelul Pacient tasta 6");
            System.out.println("Pentru tabelul Procedura tasta 7");
            System.out.println("Pentru tabelul Programare tasta 8");
            System.out.println("Pentru tabelul Specializare tasta 9");
            System.out.println("Pentru a iesi din acest meniu si a va intoarce la meniul principal apasati tasta 10");
            System.out.print("Introduceti optiunea dorita: ");
            optiune3 = scanner3.nextInt();
            switch (optiune3) {
                case 1:
                    Afectiune afectiune=new Afectiune();
                    afectiune.printAll();
                    System.out.println("Introduceti denumirea");
                    Scanner unu= new Scanner(System.in);
                    String o1;
                    o1=unu.nextLine();
                    afectiune.deleteByDenumire(o1);
                    afectiune.printAll();
                    break;
                case 2:
                    Angajat angajat=new Angajat();
                    angajat.printAll();
                    System.out.println("Introduceti Nume");
                    Scanner doi = new Scanner(System.in);
                    String o2;
                    o2=doi.nextLine();
                    System.out.println("Introduceti Prenume");
                    String op2;
                    op2=doi.nextLine();
                    angajat.deleteAllByNP(o2, op2);
                    angajat.printAll();
                    break;
                case 3:
                    Aparatura aparatura=new Aparatura();
                    aparatura.printAll();
                    System.out.println("Introduceti denumirea");
                    Scanner trei= new Scanner(System.in);
                    String o3;
                    o3=trei.nextLine();
                    aparatura.deleteByDenumire(o3);
                    aparatura.printAll();
                    break;
                case 4:
                    Cabinet cabinet=new Cabinet();
                    cabinet.printAll();
                    System.out.println("Introduceti denumirea");
                    Scanner patru=new Scanner(System.in);
                    String o4;
                    o4=patru.nextLine();
                    cabinet.deleteByDenumire(o4);
                    cabinet.printAll();
                    break;
                case 5:
                    Material material =new Material();
                    material.printAll();
                    System.out.println("Introduceti denumirea");
                    Scanner cinci = new Scanner(System.in);
                    String o5;
                    o5=cinci.nextLine();
                    material.deleteByDenumire(o5);
                    material.printAll();
                    break;
                case 6:
                    Pacient pacient=new Pacient();
                    pacient.printAll();
                    System.out.println("Introduceti Numele: ");
                    Scanner sase=new Scanner(System.in);
                    String o6=sase.nextLine();
                    System.out.println("Introduceti Prenume");
                    String op6;
                    op6=sase.nextLine();
                    pacient.deleteAllByNP(o6, op6);
                    pacient.printAll();
                    break;
                case 7:
                    Procedura procedura=new Procedura();
                    procedura.printAll();
                    System.out.println("Introduceti denumirea");
                    Scanner sapte=new Scanner(System.in);
                    String o7=sapte.nextLine();
                    procedura.deleteByDenumire(o7);
                    procedura.printAll();
                    break;
                case 8:
                    Programare programare=new Programare();
                    programare.printAll();
                    System.out.println("Introduceti Data (format: dd/MM/yyyy):");
                    Scanner opt=new Scanner(System.in);
                    String dataString=opt.nextLine();
                    System.out.print("Introduceti ora (format: HH:mm:ss): ");
                    String oraString = opt.nextLine();
                    DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate data = LocalDate.parse(dataString, dataFormatter);
                    DateTimeFormatter oraFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                    LocalTime ora = LocalTime.parse(oraString, oraFormatter);
                    programare.deleteByDataOra(data, ora);
                    programare.printAll();
                    break;
                case 9:
                    Specializare specializare=new Specializare();
                    specializare.printAll();
                    System.out.println("Introduceti denumirea");
                    Scanner noua=new Scanner(System.in);
                    String o9=noua.nextLine();
                    specializare.deleteByDenumire(o9);
                    specializare.printAll();
                    break;
                case 10:
                    meniuPrincipal();
                    break;
                default:
                    System.out.println("Optiunea introdusa este invalida. Va rugam sa incercati din nou.");
                    break;
            }
        } while (optiune3 != 10);
    }

    public void alegeTabelStergereId() {
        {
            Scanner scanner4 = new Scanner(System.in);
            int optiune4 = 0;

            do {
                System.out.println("Tabelele pe care le puteti accesa sunt:");
                System.out.println("Pentru tabelul Afectiune tasta 1");
                System.out.println("Pentru tabelul Angajat tasta 2");
                System.out.println("Pentru tabelul Aparatura tasta 3");
                System.out.println("Pentru tabelul Cabinet tasta 4");
                System.out.println("Pentru tabelul Material tasta 5");
                System.out.println("Pentru tabelul Pacient tasta 6");
                System.out.println("Pentru tabelul Procedura tasta 7");
                System.out.println("Pentru tabelul Programare tasta 8");
                System.out.println("Pentru tabelul Specializare tasta 9");
                System.out.println("Pentru a iesi din acest meniu si a va intoarce la meniul principal apasati tasta 10");
                System.out.print("Introduceti optiunea dorita: ");
                optiune4 = scanner4.nextInt();
                switch (optiune4) {
                    case 1:
                        Afectiune afectiune=new Afectiune();
                        afectiune.printAll();
                        System.out.println("Introduceti id");
                        Scanner unu= new Scanner(System.in);
                        int o1;
                        o1=unu.nextInt();
                        afectiune.deleteById(o1);
                        afectiune.printAll();
                        break;
                    case 2:
                        Angajat angajat=new Angajat();
                        angajat.printAll();
                        System.out.println("Introduceti id");
                        Scanner doi = new Scanner(System.in);
                        int o2;
                        o2=doi.nextInt();
                        angajat.deleteById(o2);
                        angajat.printAll();
                        break;
                    case 3:
                        Aparatura aparatura=new Aparatura();
                        aparatura.printAll();
                        System.out.println("Introduceti id");
                        Scanner trei= new Scanner(System.in);
                        int o3;
                        o3=trei.nextInt();
                        aparatura.deleteById(o3);
                        aparatura.printAll();
                        break;
                    case 4:
                        Cabinet cabinet=new Cabinet();
                        cabinet.printAll();
                        System.out.println("Introduceti id");
                        Scanner patru=new Scanner(System.in);
                        int o4;
                        o4=patru.nextInt();
                        cabinet.deleteById(o4);
                        cabinet.printAll();
                        break;
                    case 5:
                        Material material =new Material();
                        material.printAll();
                        System.out.println("Introduceti id");
                        Scanner cinci = new Scanner(System.in);
                        int o5;
                        o5=cinci.nextInt();
                        material.deleteById(o5);
                        material.printAll();
                        break;
                    case 6:
                        Pacient pacient=new Pacient();
                        pacient.printAll();
                        System.out.println("Introduceti Numele: ");
                        Scanner sase=new Scanner(System.in);
                        int o6=sase.nextInt();
                        pacient.deleteById(o6);
                        pacient.printAll();
                        break;
                    case 7:
                        Procedura procedura=new Procedura();
                        procedura.printAll();
                        System.out.println("Introduceti id");
                        Scanner sapte=new Scanner(System.in);
                        int o7=sapte.nextInt();
                        procedura.deleteById(o7);
                        procedura.printAll();
                        break;
                    case 8:
                        Programare programare=new Programare();
                        programare.printAll();
                        System.out.println("Introduceti id:");
                        Scanner opt=new Scanner(System.in);
                        int id=opt.nextInt();
                        programare.deleteById(id);
                        programare.printAll();
                        break;
                    case 9:
                        Specializare specializare=new Specializare();
                        specializare.printAll();
                        System.out.println("Introduceti id");
                        Scanner noua=new Scanner(System.in);
                        int o9=noua.nextInt();
                        specializare.deleteById(o9);
                        specializare.printAll();
                        break;
                    case 10:
                        meniuPrincipal();
                        break;
                    default:
                        System.out.println("Optiunea introdusa este invalida. Va rugam sa incercati din nou.");
                        break;
                }
            } while (optiune4 != 10);
        }
    }

    public void meniuPrincipal() {
        Scanner scanner2 = new Scanner(System.in);
        int optiune2 = 0;

        do {

            System.out.println("Pentru inserarea datelor intr un tabel apasati tasta 1");
            System.out.println("Pentru stergerea datelor dintr un tabel in functie de denumire/nume, prenume apasati tasta 2");
            System.out.println("Pentru stergerea datelor dintr un tabel in functie de id apasati tasta 3");
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
                    System.out.println("Ati selectat optiunea 2.");
                    System.out.println("Alegeti tabelul din care doriti sa stergeti: ");
                    alegeTabelStergereDenumire();
                    break;
                case 3:
                    System.out.println("Ati selectat optiunea 3.");
                    System.out.println("Alegeti tabelul din care doriti sa stergeti: ");
                    alegeTabelStergereId();
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

