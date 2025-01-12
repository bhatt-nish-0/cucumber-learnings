package com.example.perform.perform.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    @PostMapping("/testbrock/{akash}")
    public ResponseEntity<String> test(@RequestBody Dog d, @PathVariable String akash) {

        System.out.println("printing got what!");
        System.out.println(d.getC());
        System.out.println(akash);
        return ResponseEntity.ok("hey!");
    }
}

class Dog {
    private String c;

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }
}
