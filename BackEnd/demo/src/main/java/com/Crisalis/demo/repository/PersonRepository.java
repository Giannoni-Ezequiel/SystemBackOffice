package com.Crisalis.demo.repository;

import com.Crisalis.demo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    //void deletePersonByDNI(Integer DNI);
    //Optional<Person> findByDNIAndnombre(Integer id, String nombre);

}
