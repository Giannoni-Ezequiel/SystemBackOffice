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
    @Column(name = "IDTipo")
    private Integer tipoCliente_ID;
    @Column(name = "NombreTipo")
    private String tipoCliente_Nombre;
}
