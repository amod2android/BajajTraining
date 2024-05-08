package com.bajaj.bajajfsd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/api/v1/bajajfsd")
public class BajajfsdApplication {

    public static void main(String[] args) {
        SpringApplication.run(BajajfsdApplication.class, args);
    }

    @GetMapping("")
    public String getHello() {
        return "Hello Bajaj Fsd";
    }
}
