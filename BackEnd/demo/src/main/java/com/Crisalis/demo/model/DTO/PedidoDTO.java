package com.Crisalis.demo.model.DTO;

import com.Crisalis.demo.model.Cliente;
import com.Crisalis.demo.model.Empresa;
import com.Crisalis.demo.model.Estado;
import com.Crisalis.demo.model.Pedido;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PedidoDTO {

    @JsonProperty("ord_comprobante")
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
    @JsonProperty("cliente")
    private Cliente cliente;
    @JsonProperty("empresa")
    private Empresa empresa;

    /*public Pedido toPedidosEntity(){
        return new Pedido(this.ord_comprobante, this.ord_fecha, this.ord_TotalPedido, this.ord_NomEmpEmisora
        ,this.ord_DescuentoPorcent, this.ord_DescuentoTotal, this.estado, this.cliente);
    }*/

    public Pedido toPedidoEntity(){
        return new Pedido(this.ord_comprobante, this.ord_fecha, this.ord_TotalPedido, this.ord_NomEmpEmisora
                ,this.ord_DescuentoPorcent, this.ord_DescuentoTotal, this.estado, null);
    }

    public void set(int id) {
    }
}
