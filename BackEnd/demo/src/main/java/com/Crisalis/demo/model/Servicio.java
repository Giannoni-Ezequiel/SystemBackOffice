package com.Crisalis.demo.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@DiscriminatorValue("Servicio")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Servicio extends Bien implements Serializable {


    @Column(name = "TipoDeServicio")
    private String serv_TipoDeServicio;
    @Column(name = "ServicioEspecial")
    private Boolean serv_ServicioEspecial;
}
