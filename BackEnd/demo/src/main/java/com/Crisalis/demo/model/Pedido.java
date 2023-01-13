package com.Crisalis.demo.model;

import lombok.*;
//import com.Crisalis.demo.model.Estado;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Pedido")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {

    @Id
    @SequenceGenerator(
            name = "pedido_sequence",
            sequenceName = "pedido_sequence",
            allocationSize = 1,
            initialValue = 0
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "pedido_sequence"
    )
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
    @ManyToOne(
            fetch = FetchType.EAGER, /*el eager trae todo por mas que consultes solo 2 datos*/
            optional = false
    )
    @JoinColumn(name = "cliente_fk")
    private Cliente cliente;
    /*@OneToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    private Set<Pedido_detalle> pedido_detalle = new HashSet<>();*/

    public Pedido(Integer ord_comprobante, String ord_fecha, BigDecimal ord_TotalPedido, String ord_NomEmpEmisora,
                  Double ord_DescuentoPorcent, BigDecimal ord_DescuentoTotal, Estado estado, Cliente cliente) {
        this.ord_comprobante = ord_comprobante;
        this.ord_fecha = ord_fecha;
        this.ord_TotalPedido = ord_TotalPedido;
        this.ord_NomEmpEmisora = ord_NomEmpEmisora;
        this.ord_DescuentoPorcent = ord_DescuentoPorcent;
        this.ord_DescuentoTotal = ord_DescuentoTotal;
        this.estado = estado;
        this.cliente = cliente;
    }
}
