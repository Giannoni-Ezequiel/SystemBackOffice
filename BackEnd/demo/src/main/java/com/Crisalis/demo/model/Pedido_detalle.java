package com.Crisalis.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedido_detalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer item_ID;
    @Column(name = "Cantidad")
    private String item_cant;
    @Column(name = "PrecioUnitario")
    private BigDecimal item_PrecioUnitario;
    @Column(name = "PrecioTotal")
    private BigDecimal item_PrecioTotal;
    @Column(name = "Descuento")
    private BigDecimal item_Descuento;
    @Column(name = "Garantia")
    private Integer item_Garantia;
    @Column(name = "PorcentajeDeGarantia")
    private Double item_PorcGarantia;
    @Column(name = "CargoSoporte")
    private BigDecimal item_CargoSoporte;
    @OneToOne
    //@JoinColumn(name = "bien_ID")
    private Bien bien;
    @OneToOne
    //@JoinColumn(name = "item_ID")
    private Pedido_impuesto pedido_impuesto;
}
