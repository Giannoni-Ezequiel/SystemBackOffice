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
    @Column(name = "PorcentajeGarantia")
    private Double prod_PorcentajeGarantia;

    public Producto(String bien_Nombre, BigDecimal bien_costo
                    , BigDecimal prod_Impuesto, Double prod_PorcentajeGarantia){
        super(null, bien_Nombre, bien_costo,
                null, null);
        this.prod_Impuesto = prod_Impuesto;
        this.prod_PorcentajeGarantia = prod_PorcentajeGarantia;
    }
    @Override
    public BigDecimal calcularCosto() {
        BigDecimal resultado = bien_Costo.subtract(prod_Impuesto);
        return resultado;
    }
}
