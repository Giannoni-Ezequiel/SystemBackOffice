package com.Crisalis.demo.model.DTO;

import java.math.BigDecimal;

public class ProductoDTO {

    private String nombre;
    private BigDecimal precio;

    public ProductoDTO() {
    }

    public ProductoDTO(String nombre, BigDecimal precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
}
