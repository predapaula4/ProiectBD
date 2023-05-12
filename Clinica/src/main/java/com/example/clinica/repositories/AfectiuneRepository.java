package com.example.clinica.repositories;

import com.example.clinica.entities.Afectiune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AfectiuneRepository extends JpaRepository<Afectiune, Long> {
}