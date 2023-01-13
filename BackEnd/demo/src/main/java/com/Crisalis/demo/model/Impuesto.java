package com.Crisalis.demo.model;

import com.Crisalis.demo.model.DTO.ImpuestoDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
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
    @JoinColumn(name = "bien_ID")
    private List<Bien> Bienes = new ArrayList<>();

    public Impuesto(Float imp_Porcentaje, String imp_Nombre, List<Bien> Bienes){
        this.imp_Nombre = imp_Nombre;
        this.imp_Porcentaje = imp_Porcentaje;
        this.Bienes = Bienes;
    }
    public ImpuestoDTO toDTO(){
        return
                ImpuestoDTO
                        .builder()
                        .imp_Nombre(this.imp_Nombre)
                        .imp_Porcentaje(this.imp_Porcentaje)
                        .Bienes(this.Bienes)
                        .build();
    }
}
