package com.Crisalis.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Cliente_Tipo")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class tipo_cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID Tipo")
    private Integer tipoCliente_ID;
    @Column(name = "Nombre Tipo")
    private String tipoCliente_Nombre;
}
