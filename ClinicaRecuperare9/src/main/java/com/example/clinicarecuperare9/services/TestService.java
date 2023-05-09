package com.example.clinicarecuperare9.services;

import com.example.clinicarecuperare9.dtos.TestInterface;
import com.example.clinicarecuperare9.entities.Test;
import com.example.clinicarecuperare9.repositories.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService{
    @Autowired
    private TestRepository testRepository;

    public Test getTestById(Long id) {return testRepository.findById(id).orElse(null);}

    public void createTest(TestInterface test) {
        Test newTest = new Test(
                test.getTitle()
        );
        testRepository.save(newTest);
    }
}
