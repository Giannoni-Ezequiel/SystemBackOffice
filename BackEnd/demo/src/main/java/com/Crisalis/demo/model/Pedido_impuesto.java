package com.Crisalis.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Pedido_Impuesto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedido_impuesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer peIm_ID;
    @Column(name = "Porcentaje")
    private Integer imp_Porcentaje;
    @Column(name = "Total Impuesto Cobrado")
    private Float imp_TotalImpCobrado;
    @OneToOne
    //@JoinColumn(name = "imp_ID")
    private Impuesto impuesto;
}
