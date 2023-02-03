package com.Crisalis.demo.model;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

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
    private Integer CUIT;
    @Column(name = "fecha_de_inicio")
    private Integer fechadeinicio;

    public Empresa( String razonSocial,Integer CUIT,  Integer fechadeinicio,String email,String direccion, String telefono){
        super(email, direccion, telefono);
        this.email = email;
        this.direccion = direccion;
        this.telefono = telefono;
        this.razonSocial = razonSocial;
        this.CUIT = CUIT;
        this.fechadeinicio = fechadeinicio;
    }
    @Override
    public Boolean esMayorDeEdad() {
        boolean Resultado;
        Resultado = CUIT > 18;
        return Resultado;
    }
}

