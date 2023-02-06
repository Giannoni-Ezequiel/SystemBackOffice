package com.Crisalis.demo.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("Producto")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Producto extends Bien implements Serializable {

    @Column(name = "PorcentajeGarantia")
    private BigDecimal prod_PorcentajeGarantia;

    @ManyToMany
    @JoinTable(
            name = "bien_impuesto",
            joinColumns = {
                    @JoinColumn(name = "bienes_fk")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "impuestos_fk")
            }
    )
    private List<Impuesto> impuestoList = new ArrayList<>();

    public Producto(String bien_Nombre, BigDecimal bien_Costo
                    , BigDecimal prod_PorcentajeGarantia){
        super(bien_Nombre, bien_Costo);
        this.bien_Nombre = bien_Nombre;
        this.bien_Costo = bien_Costo;
        this.prod_PorcentajeGarantia = prod_PorcentajeGarantia;
    }
    public Producto(String bien_Nombre, BigDecimal bien_Costo)
    {
        super(bien_Nombre, bien_Costo);
    }


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
        return bien_Costo.subtract((BigDecimal) impuestoList);
    }
}
