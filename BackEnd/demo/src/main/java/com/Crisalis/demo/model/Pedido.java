package com.Crisalis.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//import com.Crisalis.demo.model.Estado;
import javax.persistence.*;
import java.math.BigDecimal;

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
    @Column(name = "NumeroComprobante")
    private Integer ord_comprobante;
    @Column(name = "Fecha")
    private String ord_fecha;
    @Column(name = "TotalDelPedido")
    private BigDecimal ord_TotalPedido;
    @Column(name = "EmpresaEmisora")
    private String ord_NomEmpEmisora;
    @Column(name = "DescuentoPorcentaje")
    private Double DescuentoPorcent;
    @Column(name = "DescuentoTotal")
    private BigDecimal DescuentoTotal;
    @OneToOne
    //@Column(name = "stat_ID")
    private Estado estado;
    @OneToOne
    private Pedido_detalle pedido_detalle;
}
