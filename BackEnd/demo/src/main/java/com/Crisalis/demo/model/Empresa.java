package com.Crisalis.demo.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@Builder
public class Empresa extends Cliente{

    @Column(name = "CUIT")
    private Integer CUIT;
    @Column(name = "razon_social")
    private String razonSocial;
    @Column(name = "fecha_de_inicio")
    private Integer fechadeinicio;

}

