package com.Crisalis.demo.model;

import com.Crisalis.demo.model.DTO.PersonDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Builder
public class Person extends Cliente{

    @Column(name = "DNI")
    private Integer DNI;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "email")
    private String email;

    public Person(PersonDTO personDTO){
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

