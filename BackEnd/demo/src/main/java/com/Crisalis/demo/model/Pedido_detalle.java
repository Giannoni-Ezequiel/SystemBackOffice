package com.Crisalis.demo.model;

import com.Crisalis.demo.model.DTO.BienDTO;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "pedido_detalle")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Pedido_detalle {

    @Id
    @SequenceGenerator(
            name = "pedido_detalle_sequence",
            sequenceName = "pedido_detalle_sequence",
            allocationSize = 1,
            initialValue = 0
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "pedido_detalle_sequence"
    )
    @Column(name = "ID")
    private Integer item_ID;
    @Column(name = "Cantidad")
    private BigDecimal item_cant;
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
    @ManyToOne(
            fetch = FetchType.EAGER
            //optional = false //No puede existir un detalle sin que este en un pedido
    )
    @JoinColumn(name = "product_fk")
    private Producto producto;
    @ManyToOne(
            fetch = FetchType.EAGER
            //optional = false //No puede existir un detalle sin que este en un pedido
    )
    @JoinColumn(name = "servicio_fk")
    private Servicio servicio;

    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "pedido_fk")
    private Pedido pedido;

    /*public Pedido_detalle(BigDecimal item_cant, BigDecimal item_PrecioUnitario, BigDecimal item_PrecioTotal,
                          BigDecimal item_Descuento, Integer item_Garantia, Double item_PorcGarantia,
                          BigDecimal item_CargoSoporte)
    {
        this.item_cant = item_cant;
        this.item_PrecioUnitario = item_PrecioUnitario;
        this.item_PrecioTotal = item_PrecioTotal;
        this.item_Descuento = item_Descuento;
        this.item_Garantia = item_Garantia;
        this.item_PorcGarantia = item_PorcGarantia;
        this.item_CargoSoporte = item_CargoSoporte;


    }*/

}
