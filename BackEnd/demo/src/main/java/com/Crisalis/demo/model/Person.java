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


    public Person(String nombre, String apellido, Integer DNI,String email,String direccion, String telefono){
        super(email, direccion, telefono);
        this.email = email;
        this.direccion = direccion;
        this.telefono = telefono;
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;

    }
    public Person(String email,String direccion, String telefono){
        super(email, direccion, telefono);
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

