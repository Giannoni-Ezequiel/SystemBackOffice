package com.Crisalis.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Impuesto")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Impuesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer imp_ID;
    @Column(name = "Porcentaje")
    private Float imp_Porcentaje;
    @Column(name = "Nombre")
    private String imp_Nombre;
    @ManyToMany
    //@JoinColumn(name = "bien_ID")
    private List<Bien> Bienes;
}
