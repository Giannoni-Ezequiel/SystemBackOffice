package com.Crisalis.demo.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Producto extends Bien{

    @Column(name = "Impuesto")
    private BigDecimal prod_Impuesto;
    @Column(name = "PrecioBase")
    private BigDecimal prod_PrecioBase;
    @Column(name = "PorcentajeGarantia")
    private Double prod_PorcentajeGarantia;

}
