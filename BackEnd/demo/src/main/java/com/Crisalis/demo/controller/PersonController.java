package com.Crisalis.demo.controller;

import com.Crisalis.demo.model.DTO.PersonDTO;
import com.Crisalis.demo.model.Person;
import com.Crisalis.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("person")
public class PersonController {

    private final PersonService personService;
    @Autowired
    public PersonController(PersonService personService)
    {
        this.personService = personService;
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person savePerson(@RequestBody PersonDTO personDTO)
    {
        return this.personService.savePerson(personDTO);
    }
}
