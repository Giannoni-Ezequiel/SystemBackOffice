package com.Crisalis.demo.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Empresa")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Empresa extends Cliente{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUIT")
    private Integer CUIT;
    @Column(name = "razon_social")
    private String razonSocial;
    @Column(name = "fecha_de_inicio")
    private Integer fechadeinicio;

}

