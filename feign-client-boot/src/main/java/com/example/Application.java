package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
@SpringBootApplication
@EnableFeignClients
public class Application {
    @Autowired
    private PersonClient personClient;

    // Because the service runs at 8080, and because Spring Boot seems to require a ServletContainer, the port is changed
    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return (container -> {
            container.setPort(8012);
        });
    }

    @Bean
    CommandLineRunner test() {
        return (args) -> {
            // The result.
            System.out.println(personClient.getPersons().getContent());
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
