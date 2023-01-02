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
    @ManyToOne
    @JoinColumn(name = "bien_ID")
    private String bien_ID;
    @ManyToOne
    @JoinColumn(name = "ord_ID")
    private Integer ord_ID;
    @Column(name = "Precio Unitario")
    private float item_PrecioUnitario;
    @Column(name = "Precio Total")
    private float item_PrecioTotal;
    @Column(name = "Descuento")
    private float item_Descuento;
    @Column(name = "Garantia")
    private Integer item_Garantia;
    @Column(name = "Porcentaje de Garantia")
    private float item_PorcGarantia;
    @Column(name = "Cargo Soporte")
    private float item_CargoSoporte;
}
