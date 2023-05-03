package org.example;

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
                default:
                    System.out.println("Optiunea introdusa este invalida. Va rugam sa incercati din nou.");
                    break;
            }
        } while (optiune != 9);
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
                    System.out.println("Introduceti denumirea");
                    Scanner doi = new Scanner(System.in);
                    String o2;
                    o2=doi.nextLine();
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

                    break;
                case 5:
                    Material material =new Material("Benzi");
                    material.printAll();
                    System.out.println("Introduceti denumirea");
                    Scanner cinci = new Scanner(System.in);
                    String o5;
                    o5=cinci.nextLine();
                    material.deleteByDenumire(o5);
                    material.printAll();
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Optiunea introdusa este invalida. Va rugam sa incercati din nou.");
                    break;
            }
        } while (optiune3 != 9);
    }


    public void meniuPrincipal()
    {
        Scanner scanner2 = new Scanner(System.in);
        int optiune2 = 0;

        do {

            System.out.println("Pentru inserarea datelor intr un tabel apasati tasta 1");
            System.out.println("Pentru stergerea datelor dintr un tabel in functie de denumire/nume, prenume apasati tasta 2");
            System.out.println("Pentru stergerea datelor dintr un tabel in functie de id apasati tasta 3");
            System.out.println("4. Iesire");

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
                    // adauga aici codul pentru optiunea 3
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

