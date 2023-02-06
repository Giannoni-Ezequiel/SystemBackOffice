package com.Crisalis.demo.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany
    @JoinTable(
            name = "bien_impuesto",
            joinColumns = {
                    @JoinColumn(name = "bienes_fk")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "impuestos_fk")
            }
    )
    private List<Impuesto> impuestoList = new ArrayList<>();

    public Servicio(String bien_Nombre, BigDecimal bien_Costo, BigDecimal serv_CargoSoporte
            , Boolean serv_ServicioEspecial){
        super(bien_Nombre, bien_Costo);
        this.bien_Nombre = bien_Nombre;
        this.bien_Costo = bien_Costo;
        this.serv_CargoSoporte = serv_CargoSoporte;
        this.serv_ServicioEspecial = serv_ServicioEspecial;

    }
    public Servicio(String bien_Nombre, BigDecimal bien_Costo){
        super(bien_Nombre, bien_Costo);
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
