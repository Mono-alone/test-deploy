package com.example.testdeploy;

import org.springframework.boot.SpringApplication;

public class TestTestDeployApplication {

    public static void main(String[] args) {
        SpringApplication.from(TestDeployApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
