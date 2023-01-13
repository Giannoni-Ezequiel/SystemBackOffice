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

    public Producto(String bien_Nombre, BigDecimal bien_costo, Double bien_CargoSoporte, BigDecimal bien_PorcentajeCarg
                    , BigDecimal prod_Impuesto, BigDecimal prod_PrecioBase, Double prod_PorcentajeGarantia){
        super(null, bien_Nombre, bien_costo, bien_CargoSoporte, bien_PorcentajeCarg,
                null, null);
        this.prod_Impuesto = prod_Impuesto;
        this.prod_PrecioBase = prod_PrecioBase;
        this.prod_PorcentajeGarantia = prod_PorcentajeGarantia;
    }
}
