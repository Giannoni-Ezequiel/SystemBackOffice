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
public class Servicio extends Bien implements Serializable {

    @Column(name = "CargoSoporte")
    private BigDecimal serv_CargoSoporte;
    @Column(name = "ServicioEspecial")
    private Boolean serv_ServicioEspecial;

    public Servicio(String tipo, String bien_Nombre, BigDecimal bien_Costo, BigDecimal serv_CargoSoporte, Boolean serv_ServicioEspecial){}
    public Servicio(String bien_Nombre, BigDecimal bien_costo, BigDecimal serv_CargoSoporte
            , Boolean serv_ServicioEspecial){
        super(bien_Nombre, bien_costo);
        this.serv_CargoSoporte = serv_CargoSoporte;
        this.serv_ServicioEspecial = serv_ServicioEspecial;

    }
    /*@Override
    public BienDTO toDTO() {
        return
                BienDTO
                        .builder()
                        .id(this.bien_ID)
                        .bien_Nombre(this.bien_Nombre)
                        .bien_Costo(this.bien_Costo)
                        .serv_CargoSoporte(this.serv_CargoSoporte)
                        .serv_ServicioEspecial(this.serv_ServicioEspecial)
                        .build();
    }*/

    public BigDecimal calcularCosto() {
        return bien_Costo.subtract(serv_CargoSoporte);
    }
}
