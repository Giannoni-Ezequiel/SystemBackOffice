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
@Builder
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
    private float ord_TotalPedido;
    @Column(name = "Empresa Emisora")
    private String ord_NomEmpEmisora;
    @ManyToOne
    @JoinColumn(name = "stat_ID")
    private Integer stat_ID;
    @Column(name = "Descuento Porcentaje")
    private float DescuentoPorcent;
    @Column(name = "Descuento Total")
    private float DescuentoTotal;
}
