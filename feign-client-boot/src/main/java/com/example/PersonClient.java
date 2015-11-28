package com.example;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(url = "http://localhost:8080")
public interface PersonClient {
    @RequestMapping(method = RequestMethod.GET, value = "/persons")
    Resources<Person> getPersons();
}
