package com.Crisalis.demo.model;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("Empresa")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
//@Builder
public class Empresa extends Cliente implements Serializable {
    @Column(name = "razon_social")
    private String razonSocial;
    @Column(name = "CUIT")
    private String CUIT;
    @Column(name = "fecha_de_inicio")
    private LocalDate fechadeinicio;
    @OneToOne
    private Person persona;
    public Empresa( String razonSocial,String CUIT,  LocalDate fechadeinicio,String email,String direccion,
                    String telefono, Person persona){
        super(email, direccion, telefono);
        this.email = email;
        this.direccion = direccion;
        this.telefono = telefono;
        this.razonSocial = razonSocial;
        this.CUIT = CUIT;
        this.fechadeinicio = fechadeinicio;
        this.persona = persona;
    }
    @Override
    public Boolean esMayorDeEdad() {
        boolean Resultado;
        Resultado = CUIT == "q";
        return Resultado;
    }
}

