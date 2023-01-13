package com.Crisalis.demo.model.DTO;

import com.Crisalis.demo.model.Bien;
import com.Crisalis.demo.model.Impuesto;
import com.Crisalis.demo.model.Person;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class ImpuestoDTO {

    @JsonProperty("Porcentaje")
    private Float imp_Porcentaje;
    @JsonProperty("Nombre")
    private String imp_Nombre;
    @JsonProperty("Bienes")
    private List<Bien> Bienes;

    public Impuesto toImpuestoEntity(){
        return new Impuesto(this.imp_Porcentaje, this.imp_Nombre, this.Bienes);
    }
}
