package com.Crisalis.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Bienes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Bien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer bien_ID;
    @Column(name = "Nombre")
    private float bien_Nombre;
    @ManyToOne
    @JoinColumn(name = "tipoBien_ID")
    private Integer tipoBien_ID;
    @Column(name = "Costo")
    private float bien_Costo;
    @Column(name = "Cargo Soporte")
    private float bien_CargoSoporte;
    @Column(name = "¿Es especial?")
    private boolean bien_EsEspecial;
    @Column(name = "Porcentaje de cargo")
    private float bien_PorcentajCarg;


}
