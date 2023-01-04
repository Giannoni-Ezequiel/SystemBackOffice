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

    @Column(name = "ID Producto")
    private Integer prod_ID;
    @Column(name = "Nombre Producto")
    private String prod_Nombre;
    @Column(name = "Impuesto")
    private float prod_Impuesto;
    @Column(name = "Precio Base")
    private float prod_PrecioBase;
    @Column(name = "Porcentaje Garantia")
    private float prod_PorcentajeGarantia;

}
