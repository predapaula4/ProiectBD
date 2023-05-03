package org.example;
public class Main {
    public static void main(String[] args) {
        Angajat angajat = new Angajat( 1, "Pop", "Karina", 2000);
        angajat.save();
        System.out.println(angajat);

    }
}