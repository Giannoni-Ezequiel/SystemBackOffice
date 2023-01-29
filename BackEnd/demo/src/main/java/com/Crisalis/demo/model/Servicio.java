package com.Crisalis.demo.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue("Servicio")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Servicio extends Bien implements Serializable {

    @Column(name = "CargoSoporte")
    private BigDecimal serv_CargoSoporte;
    @Column(name = "ServicioEspecial")
    private Boolean serv_ServicioEspecial;

    public Servicio(String bien_Nombre, BigDecimal bien_costo, BigDecimal serv_CargoSoporte
            , Boolean serv_ServicioEspecial){
        super(null, bien_Nombre, bien_costo,
                null, null);
        this.serv_CargoSoporte = serv_CargoSoporte;
        this.serv_ServicioEspecial = serv_ServicioEspecial;

    }

    @Override
    public BigDecimal calcularCosto() {
        BigDecimal resultado = bien_Costo.subtract(serv_CargoSoporte);
        return resultado;
    }
}
