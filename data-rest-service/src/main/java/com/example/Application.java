package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    @Autowired
    private PersonRepository personRepository;

    @Bean
    CommandLineRunner test() {
        return (args) -> {
            personRepository.save(new Person("Foo1"));
            personRepository.save(new Person("Foo2"));
            personRepository.save(new Person("Foo3"));
            personRepository.save(new Person("Foo4"));

            System.out.println(personRepository.findAll());
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}