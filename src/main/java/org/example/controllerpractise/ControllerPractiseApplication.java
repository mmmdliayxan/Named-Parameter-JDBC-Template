package org.example.controllerpractise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ControllerPractiseApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ControllerPractiseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
