package com.example.clinicarecuperare9.controllers;

import com.example.clinicarecuperare9.dtos.TestInterface;
import com.example.clinicarecuperare9.entities.Test;
import com.example.clinicarecuperare9.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/test")
public class TestResource {

    @Autowired
    private TestService testService;

    @GetMapping(path = "/echo")
    public String getEcho() {
        return "Echo 1.. 2.. 3..";
    }

    @GetMapping(path = "/hello/{name}")
    public String helloApp(@PathVariable String name) {
        return "Hello " + name;
    }

    @PostMapping()
    public void saveTest(@RequestBody TestInterface test){
        testService.createTest(test);
    }
    @GetMapping()
    public Test getTest(@RequestParam("testId") Long testId){
        return testService.getTestById(testId);
    }
}