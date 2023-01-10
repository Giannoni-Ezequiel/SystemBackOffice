package com.Crisalis.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//import com.Crisalis.demo.model.Estado;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

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
    private Double ord_DescuentoPorcent;
    @Column(name = "DescuentoTotal")
    private BigDecimal ord_DescuentoTotal;
    @Column(name = "Estado")
    private Estado estado;
    @OneToMany
    private List<Pedido_detalle> pedido_detalle;
}
