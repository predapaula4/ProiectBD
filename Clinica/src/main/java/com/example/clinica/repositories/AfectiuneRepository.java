package com.example.clinica.repositories;

import com.example.clinica.entities.Afectiune;
import com.example.clinica.entities.Angajat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AfectiuneRepository extends JpaRepository<Afectiune, Long> {

}