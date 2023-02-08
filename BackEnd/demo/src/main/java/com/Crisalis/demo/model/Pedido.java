package com.Crisalis.demo.model;

import com.Crisalis.demo.model.DTO.PedidoDTO;
import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

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
    @Column(name = "ServicioDescuento")
    private String ord_ServicioDescuento;
    @Column(name = "DescuentoPorcentaje")
    private BigDecimal ord_DescuentoPorcent;
    @Column(name = "DescuentoTotal")
    private BigDecimal ord_DescuentoTotal;
    @Column(name = "Estado")
    private Boolean estado;
    @ManyToOne(
            fetch = FetchType.EAGER /*el eager trae todo por mas que consultes solo 2 datos*/
            //optional = false
    )
    @JoinColumn(name = "empresa_fk")
    private Empresa empresa;
    @ManyToOne(
            fetch = FetchType.EAGER /*el eager trae todo por mas que consultes solo 2 datos*/
            //optional = false
    )
    @JoinColumn(name = "persona_fk")
    private Person persona;

    public Pedido(Integer id, Integer ord_comprobante, LocalDate now, BigDecimal ord_totalPedido,
                  String ord_nomEmpEmisora, String ord_servicioDescuento,
                  BigDecimal ord_descuentoPorcent, BigDecimal ord_descuentoTotal, boolean estado,
                  Optional<Empresa> empresa, Object persona) {
    }

    @OneToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "pedido_fk")
    //private Set<Pedido_detalle> pedido_detalle = new HashSet<>();
    private List<Pedido_detalle> pedido_detalle = new ArrayList<Pedido_detalle>();

    public Pedido(Integer ord_comprobante, LocalDate ord_fecha, BigDecimal ord_TotalPedido, String ord_NomEmpEmisora,
                  BigDecimal ord_DescuentoPorcent, BigDecimal ord_DescuentoTotal, Boolean estado,
                  List<Pedido_detalle> pedido_detalle, Empresa empresa, Person persona) {
        this.ord_comprobante = ord_comprobante;
        this.ord_fecha = ord_fecha;
        this.ord_TotalPedido = ord_TotalPedido;
        this.ord_NomEmpEmisora = ord_NomEmpEmisora;
        this.ord_DescuentoPorcent = ord_DescuentoPorcent;
        this.ord_DescuentoTotal = ord_DescuentoTotal;
        this.estado = estado;
        this.pedido_detalle = pedido_detalle;
        this.empresa = empresa;
        this.persona = persona;
    }

}
