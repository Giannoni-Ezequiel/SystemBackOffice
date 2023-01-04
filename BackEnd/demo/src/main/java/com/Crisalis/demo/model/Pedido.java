package com.Crisalis.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//import com.Crisalis.demo.model.Estado;
import javax.persistence.*;

@Entity
@Table(name = "Pedido")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "N° Comprobante")
    private String ord_comprobante;
    @Column(name = "Fecha")
    private String ord_fecha;
    @Column(name = "Total del Pedido")
    private Float ord_TotalPedido;
    @Column(name = "Empresa Emisora")
    private String ord_NomEmpEmisora;
    @Column(name = "Descuento Porcentaje")
    private Float DescuentoPorcent;
    @Column(name = "Descuento Total")
    private Float DescuentoTotal;
    @OneToOne
    //@Column(name = "stat_ID")
    private Estado estado;
    @OneToOne
    private Pedido_detalle pedido_detalle;
}
