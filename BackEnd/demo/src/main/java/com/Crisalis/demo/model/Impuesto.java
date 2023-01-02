package com.Crisalis.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Impuesto")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Impuesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer imp_ID;
    @Column(name = "Porcentaje")
    private float imp_Porcentaje;
    @Column(name = "Nombre")
    private String imp_Nombre;
}
