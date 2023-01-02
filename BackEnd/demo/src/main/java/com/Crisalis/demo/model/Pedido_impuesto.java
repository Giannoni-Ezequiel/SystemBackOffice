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
    @ManyToOne
    @JoinColumn(name = "imp_ID")
    private Integer imp_ID;
    @ManyToOne
    @JoinColumn(name = "item_ID")
    private Integer item_ID;
    @Column(name = "Porcentaje")
    private Integer imp_Porcentaje;
    @Column(name = "Total Impuesto Cobrado")
    private float imp_TotalImpCobrado;
}
