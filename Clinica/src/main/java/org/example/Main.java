package org.example;

import org.example.Angajat;

public class Main {
    public static void main(String[] args) {
        Angajat angajat = new Angajat( 1, "Pop", "Karina", 2000);
        angajat.save();
        //System.out.println(angajat);
    }
}