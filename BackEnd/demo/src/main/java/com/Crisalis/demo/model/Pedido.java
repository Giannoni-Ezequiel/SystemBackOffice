package com.Crisalis.demo.model;

import com.Crisalis.demo.model.DTO.PedidoDTO;
import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Pedido")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
    private LocalDate ord_fecha;
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

    @OneToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "pedido_fk")
    private Set<Pedido_detalle> pedido_detalle = new HashSet<>();
    //List<Pedido_detalle> lista = new ArrayList<Pedido_detalle> ();

    public Pedido(Integer ord_comprobante, LocalDate ord_fecha, BigDecimal ord_TotalPedido, String ord_NomEmpEmisora,
                  Double ord_DescuentoPorcent, BigDecimal ord_DescuentoTotal, Estado estado,
                  Set<Pedido_detalle> pedido_detalle, Cliente cliente) {
        this.ord_comprobante = ord_comprobante;
        this.ord_fecha = ord_fecha;
        this.ord_TotalPedido = ord_TotalPedido;
        this.ord_NomEmpEmisora = ord_NomEmpEmisora;
        this.ord_DescuentoPorcent = ord_DescuentoPorcent;
        this.ord_DescuentoTotal = ord_DescuentoTotal;
        this.estado = estado;
        this.pedido_detalle = pedido_detalle;
        this.cliente = cliente;
    }

    public PedidoDTO toDTO()
    {
        return
                PedidoDTO
                        .builder()
                        .ord_comprobante(this.ord_comprobante)
                        .ord_fecha(this.ord_fecha)
                        .ord_TotalPedido(this.ord_TotalPedido)
                        .ord_DescuentoPorcent(this.ord_DescuentoPorcent)
                        .ord_DescuentoTotal(this.ord_DescuentoTotal)
                        .estado(this.estado)
                        .pedido_detalle(this.pedido_detalle)
                        .cliente(this.cliente)
                        .build();
    }

}
