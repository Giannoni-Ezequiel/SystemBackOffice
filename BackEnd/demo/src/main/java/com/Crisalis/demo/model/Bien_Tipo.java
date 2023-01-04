package com.Crisalis.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Bien_Tipo")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Bien_Tipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer tipoBien_ID;
    @Column(name = "Nombre")
    private String tipoBien_Nombre;
}
