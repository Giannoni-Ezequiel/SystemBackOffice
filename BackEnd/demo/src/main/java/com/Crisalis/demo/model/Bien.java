package com.Crisalis.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.math.BigDecimal;
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
    private String bien_Nombre;
    @ManyToOne
    //@JoinColumn(name = "tipoBien_ID")
    private Bien_Tipo bienTipo;
    @Column(name = "Costo")
    private BigDecimal bien_Costo;
    @Column(name = "CargoSoporte")
    private Double bien_CargoSoporte;
    @Column(name = "EsEspecial")
    private Boolean bien_EsEspecial;
    @Column(name = "PorcentajeDeCargo")
    private BigDecimal bien_PorcentajCarg;
    @ManyToMany
    //@JoinColumn(name = "imp_ID")
    private List<Impuesto> Impuestos;


}
