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

    @Column(name = "CUIT")
    private Integer CUIT;
    @Column(name = "razon_social")
    private String razonSocial;
    @Column(name = "fecha_de_inicio")
    private Integer fechadeinicio;

    public Empresa(String direccion, String telefono, Integer CUIT, String razonSocial, Integer fechadeinicio){
        super(direccion, telefono);
        this.CUIT = CUIT;
        this.razonSocial = razonSocial;
        this.fechadeinicio = fechadeinicio;
    }


    @Override
    public Boolean esMayorDeEdad() {
        boolean Resultado;
        Resultado = CUIT > 18;
        return Resultado;
    }
}

