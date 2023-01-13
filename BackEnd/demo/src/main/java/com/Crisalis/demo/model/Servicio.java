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


    @Column(name = "TipoDeServicio")
    private String serv_TipoDeServicio;
    @Column(name = "ServicioEspecial")
    private Boolean serv_ServicioEspecial;

    public Servicio(String bien_Nombre, BigDecimal bien_costo, Double bien_CargoSoporte, BigDecimal bien_PorcentajeCarg
            , String serv_TipoDeServicio, Boolean serv_ServicioEspecial){
        super(null, bien_Nombre, bien_costo, bien_CargoSoporte, bien_PorcentajeCarg,
                null, null);
        this.serv_TipoDeServicio = serv_TipoDeServicio;
        this.serv_ServicioEspecial = serv_ServicioEspecial;

    }
}
