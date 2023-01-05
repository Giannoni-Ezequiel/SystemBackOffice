package com.Crisalis.demo.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Servicio extends Bien{


    @Column(name = "TipoDeServicio")
    private String serv_TipoDeServicio;
    @Column(name = "ServicioEspecial")
    private Boolean serv_ServicioEspecial;
}
