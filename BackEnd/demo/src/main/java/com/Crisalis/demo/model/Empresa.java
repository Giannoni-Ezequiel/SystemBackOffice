package com.Crisalis.demo.model;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@DiscriminatorValue("Empresa")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@Builder
public class Empresa extends Cliente implements Serializable {

    @Column(name = "CUIT", nullable = false, length = 15)
    private Integer CUIT;
    @Column(name = "razon_social")
    private String razonSocial;
    @Column(name = "fecha_de_inicio")
    private Integer fechadeinicio;

}

