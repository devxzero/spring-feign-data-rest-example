package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    private PersonClient personClient;

    @RequestMapping(value="/persons",method = RequestMethod.GET)
    public Resources<Person> getPersons(){
        Resources<Person> persons = personClient.getPersons();
        return persons;
    }

}
