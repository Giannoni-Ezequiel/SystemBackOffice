package com.Crisalis.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Bienes")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Bien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer bien_ID;
    @Column(name = "Nombre")
    private Float bien_Nombre;
    @OneToOne
    //@JoinColumn(name = "tipoBien_ID")
    private Bien_Tipo bienTipo;
    @Column(name = "Costo")
    private Float bien_Costo;
    @Column(name = "Cargo Soporte")
    private Float bien_CargoSoporte;
    @Column(name = "¿Es especial?")
    private Boolean bien_EsEspecial;
    @Column(name = "Porcentaje de cargo")
    private Float bien_PorcentajCarg;
    @ManyToMany
    //@JoinColumn(name = "imp_ID")
    private List<Impuesto> Impuestos;


}
