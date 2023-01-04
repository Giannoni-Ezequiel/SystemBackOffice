package com.Crisalis.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Servicio extends Bien{

    @Column(name = "ID Servicio")
    private Integer serv_ID;
    @Column(name = "Nombre Servicio")
    private Integer serv_Nombre;
    @Column(name = "Tipo de servicio")
    private Integer serv_TipoDeServicio;
    @Column(name = "Servicio especial")
    private Integer serv_ServicioEspecial;
}
