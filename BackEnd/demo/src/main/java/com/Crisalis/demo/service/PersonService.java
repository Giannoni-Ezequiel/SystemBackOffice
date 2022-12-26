package com.Crisalis.demo.service;

import com.Crisalis.demo.exception.custom.NotCreatedException;
import com.Crisalis.demo.model.DTO.PersonDTO;
import com.Crisalis.demo.model.Person;
import com.Crisalis.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public Person savePerson(PersonDTO personDTO){
        /*if(checkUserForSaveOrLogin(personDTO, Boolean.FALSE)){
            return this.personRepository.save(new Person(personDTO));
        }*/
        throw new NotCreatedException("Error in save new user");
    }
}
