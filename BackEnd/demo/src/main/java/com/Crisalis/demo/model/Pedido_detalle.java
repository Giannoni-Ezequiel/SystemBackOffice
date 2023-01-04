package com.Crisalis.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedido_detalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer item_ID;
    @Column(name = "nombre")
    private String item_cant;

    @Column(name = "Precio Unitario")
    private Float item_PrecioUnitario;
    @Column(name = "Precio Total")
    private Float item_PrecioTotal;
    @Column(name = "Descuento")
    private Float item_Descuento;
    @Column(name = "Garantia")
    private Integer item_Garantia;
    @Column(name = "Porcentaje de Garantia")
    private Float item_PorcGarantia;
    @Column(name = "Cargo Soporte")
    private Float item_CargoSoporte;
    @OneToOne
    //@JoinColumn(name = "bien_ID")
    private Bien bien;
    @OneToOne
    //@JoinColumn(name = "item_ID")
    private Pedido_impuesto pedido_impuesto;
}
