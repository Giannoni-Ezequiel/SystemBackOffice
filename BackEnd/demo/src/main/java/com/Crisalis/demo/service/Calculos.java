package com.Crisalis.demo.service;

import com.Crisalis.demo.exception.custom.NotFoundException;
import com.Crisalis.demo.model.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
@Service
public class Calculos {

    //CALCULOS DEL DETALLE DE UN PEDIDO

    public BigDecimal calcularPrecioUnitario(Producto producto, Servicio servicio) {

        BigDecimal impuestoTotal = BigDecimal.valueOf(0);
        BigDecimal precioUnitario = BigDecimal.valueOf(0);

        //Calculos con Productos
        if(producto !=null){
            List<Impuesto> taxList = producto.getImpuestoList();
            Function<Impuesto, BigDecimal> total = Impuesto::getImp_Porcentaje;

            BigDecimal sumTaxes = taxList.stream()
                    .map(total)
                    .reduce(BigDecimal.ZERO, BigDecimal::add );

            precioUnitario = precioUnitario.add(producto.getBien_Costo());
            impuestoTotal = precioUnitario.multiply(sumTaxes);
            precioUnitario = precioUnitario.add(impuestoTotal);

            return precioUnitario;

        //Calculos con Servicios
        } else if (servicio !=null){
            List<Impuesto> taxList = servicio.getImpuestoList();
            Function<Impuesto, BigDecimal> total = Impuesto::getImp_Porcentaje;

            BigDecimal sumTaxes = taxList.stream()
                    .map(total)
                    .reduce(BigDecimal.ZERO, BigDecimal::add );

            precioUnitario = precioUnitario.add(servicio.getBien_Costo());
            impuestoTotal = precioUnitario.multiply(sumTaxes);
            precioUnitario = precioUnitario.add(impuestoTotal);

            return precioUnitario;
        } else {
            throw new NotFoundException("No hay bienes asociados");
        }
    }

    public BigDecimal calcularSubTotal (Pedido_detalle pedido_detalle) {
        BigDecimal SubtotalItemPrecio = BigDecimal.valueOf(0);
        if (pedido_detalle.getProducto() != null) {
            SubtotalItemPrecio = pedido_detalle.getItem_cant()
                    .compareTo(BigDecimal.ONE)==1 ? pedido_detalle.getItem_PrecioUnitario()
                    .multiply(pedido_detalle.getItem_cant()) : pedido_detalle.getItem_PrecioUnitario();

            SubtotalItemPrecio = SubtotalItemPrecio.add(pedido_detalle.getItem_PorcGarantia());

            return SubtotalItemPrecio;
        } else if (pedido_detalle.getServicio() != null){
            SubtotalItemPrecio = SubtotalItemPrecio.add(pedido_detalle.getItem_PrecioUnitario());
            SubtotalItemPrecio = pedido_detalle.getServicio()
                    .getServ_ServicioEspecial() ? SubtotalItemPrecio
                    .add(pedido_detalle.getItem_CargoSoporte()) : SubtotalItemPrecio.add(BigDecimal.ZERO);

            return SubtotalItemPrecio;
        } else {
            throw new NotFoundException("There are no assets associated");
        }
    }

    public BigDecimal calcularGarantiaTotal (Pedido_detalle pedido_detalle) {
        BigDecimal totalGarantia = BigDecimal.valueOf(0);
        if (pedido_detalle.getItem_Garantia().compareTo(BigDecimal.ZERO)>0){
            totalGarantia = pedido_detalle.getItem_Garantia()
                    .multiply(pedido_detalle.getItem_PrecioUnitario())
                    .multiply(pedido_detalle.getItem_PorcGarantia())
                    .multiply(pedido_detalle.getItem_cant());
        }
        return totalGarantia;
    }

    public BigDecimal calcularDescuentoTotal (List<Pedido_detalle> pedidoDetalleList) {
        BigDecimal totalDiscount = BigDecimal.valueOf(0);
        BigDecimal totalProductsPrice;
        List<Pedido_detalle> pedidoProductoList = pedidoDetalleList.stream()
                .filter(pedidoDetalle -> pedidoDetalle.getProducto() != null)
                .collect(Collectors.toList());
        Function<Pedido_detalle, BigDecimal> total = orderAssetDetail -> orderAssetDetail.getItem_PrecioUnitario()
                .multiply(orderAssetDetail.getItem_cant());
        if(!pedidoProductoList.isEmpty()){
            totalProductsPrice = pedidoProductoList.stream()
                    .map(total)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
            totalDiscount = totalProductsPrice.multiply(BigDecimal.valueOf(0.10)).compareTo(BigDecimal.valueOf(2500))<0 ?
                    totalProductsPrice.multiply(BigDecimal.valueOf(0.10)) : BigDecimal.valueOf(2500);
            return totalDiscount;
        }
        return totalDiscount;
    }
}
