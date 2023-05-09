package com.example.clinicarecuperare9.repositories;

import com.example.clinicarecuperare9.entities.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {

}