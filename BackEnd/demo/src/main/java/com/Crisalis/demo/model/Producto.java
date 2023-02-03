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
@Builder
@AllArgsConstructor

public class Producto extends Bien implements Serializable {

    @Column(name = "Impuesto")
    private BigDecimal prod_Impuesto;
    @Column(name = "PorcentajeGarantia")
    private BigDecimal prod_PorcentajeGarantia;

    public Producto(String bien_Nombre, String bien_nombre, BigDecimal bien_costo
                    , BigDecimal prod_Impuesto, BigDecimal prod_PorcentajeGarantia){
        super(bien_Nombre, bien_costo);
        this.prod_Impuesto = prod_Impuesto;
        this.prod_PorcentajeGarantia = prod_PorcentajeGarantia;
    }
    public Producto(){}


    /*public BienDTO toDTO() {
        return
                BienDTO
                        .builder()
                        .id(this.bien_ID)
                        .bien_Nombre(this.bien_Nombre)
                        .bien_Costo(this.bien_Costo)
                        .prod_Impuesto(this.prod_Impuesto)
                        .prod_PorcentajeGarantia(this.prod_PorcentajeGarantia)
                        .build();
    }*/

    public BigDecimal calcularCosto() {
        return bien_Costo.subtract(prod_Impuesto);
    }
}
