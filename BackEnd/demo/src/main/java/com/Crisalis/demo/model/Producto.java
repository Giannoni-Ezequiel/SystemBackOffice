package com.Crisalis.demo.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue("Producto")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Producto extends Bien implements Serializable {

    @Column(name = "Impuesto")
    private BigDecimal prod_Impuesto;
    @Column(name = "PrecioBase")
    private BigDecimal prod_PrecioBase;
    @Column(name = "PorcentajeGarantia")
    private Double prod_PorcentajeGarantia;

}
