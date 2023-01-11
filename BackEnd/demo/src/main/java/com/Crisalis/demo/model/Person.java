package com.Crisalis.demo.model;

import com.Crisalis.demo.model.DTO.PersonDTO;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@DiscriminatorValue("Persona Fisica")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@Builder
public class Person extends Cliente implements Serializable {

    @Column(name = "DNI", nullable = false, length = 8)
    private Integer DNI;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "email")
    private String email;
}
    /*public Person(PersonDTO personDTO){
        this.DNI = personDTO.getDNI();
        this.nombre = personDTO.getNombre();
        this.apellido = personDTO.getApellido();
        this.email = personDTO.getEmail();
    }
    public PersonDTO toDTO(){
        return
                PersonDTO
                        .builder()
                        .DNI(this.DNI)
                        .nombre(this.nombre)
                        .apellido(this.apellido)
                        .email(this.email)
                        .build();
    }
}

    /*public PersonParam toDto(){
        PersonParam personParam = new PersonParam();
        personParam.setid
                return personParam;
    }*/

