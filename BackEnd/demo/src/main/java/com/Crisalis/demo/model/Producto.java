package com.Crisalis.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto extends Bien{

    @Column(name = "ID")
    private Integer prod_ID;
    @Column(name = "Nombre")
    private String prod_Nombre;
    @Column(name = "Impuesto")
    private float prod_Impuesto;
    @Column(name = "razon_social")
    private float prod_PrecioBase;
    @Column(name = "razon_social")
    private float prod_PorcentajeGarantia;

}
