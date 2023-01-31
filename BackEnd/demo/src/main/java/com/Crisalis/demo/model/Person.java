package com.Crisalis.demo.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@DiscriminatorValue("Persona Fisica")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
//@Builder
public class Person extends Cliente implements Serializable {

    @Column(name = "DNI")
    private Integer DNI;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "email")
    private String email;

    public Person(String direccion, String telefono, Integer DNI, String nombre, String apellido, String email){
        super(direccion, telefono);
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    @Override
    public Boolean esMayorDeEdad() {
        boolean Resultant;
        Resultant = DNI > 18;
        return Resultant;
    }
}

    /*public PersonParam toDto(){
        PersonParam personParam = new PersonParam();
        personParam.setid
                return personParam;
    }*/

