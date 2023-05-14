package com.example.clinica.repositories;

import com.example.clinica.entities.Angajat;
import com.example.clinica.entities.Pacient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacientRepository extends JpaRepository<Pacient, Long> {
    Pacient findByNumeAndPrenume(String nume, String prenume);

}