package com.Crisalis.demo.model.DTO;

import com.Crisalis.demo.model.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PedidoDTO {

    @JsonProperty("id")
    private Integer id;
    /*@JsonProperty("ord_comprobante")
    private Integer ord_comprobante;
    @JsonProperty("ord_fecha")
    private LocalDate ord_fecha;
    @JsonProperty("ord_totalPedido")
    private BigDecimal ord_TotalPedido;
    @JsonProperty("ord_NomEmpEmisora")
    private String ord_NomEmpEmisora;
    @JsonProperty("ord_DescuentoPorcent")
    private Double ord_DescuentoPorcent;
    @JsonProperty("ord_DescuentoTotal")
    private BigDecimal ord_DescuentoTotal;
    @JsonProperty("estado")
    private Estado estado;
    @JsonProperty("persona")
    private Person persona;
    @JsonProperty("empresa")
    private Empresa empresa;*/
    @JsonProperty("id_cliente")
    private Integer idCliente;
    @JsonProperty("detalle")
    private List<Pedido_detalle> pedido_detalle = new ArrayList();

    /*public Pedido toPedidosEntity(){
        return new Pedido(this.ord_comprobante, this.ord_fecha, this.ord_TotalPedido, this.ord_NomEmpEmisora
        ,this.ord_DescuentoPorcent, this.ord_DescuentoTotal, this.estado, this.cliente);
    }

    public Pedido toPedidoEntity(){
        return new Pedido(this.ord_comprobante, this.ord_fecha, this.ord_TotalPedido, this.ord_NomEmpEmisora
                ,this.ord_DescuentoPorcent, this.ord_DescuentoTotal, this.estado, (Set<Pedido_detalle>) this.cliente,
                (Cliente) this.pedido_detalle);
    }*/
    public PedidoDTO toDto(Pedido pedido)
    {
        return
                PedidoDTO
                        .builder()
                        .id(pedido.getId())
                        .idCliente(pedido.getEmpresa() != null ? pedido.getEmpresa().getId() : pedido.getPersona().getId())
                        .build();
    }
    public Pedido toEntity(PedidoDTO pedidoDTO, Empresa empresa, Person persona) {
        return Pedido.builder()
                    .id(pedidoDTO.getId())
                .ord_fecha(LocalDate.now())
                .empresa(empresa)
                .persona(persona)
                .estado(true)
                .build();
    }

    public static DetalleDTO pedidoDetalleToDto(Pedido pedido, List<Pedido_detalle> pedidoDetalleList){
        return DetalleDTO.builder()
                .id(pedido.getId())


                //.empresa(pedido.getEmpresa() != null ? pedido.getEmpresa(): null)
                //.person()
                .build();
    }
}
