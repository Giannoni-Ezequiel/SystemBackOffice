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
@Builder
public class tipo_cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer tipoCliente_ID;
    @Column(name = "Nombre")
    private String tipoCliente_Nombre;
}
