package com.Crisalis.demo.model.DTO;

import com.Crisalis.demo.model.Bien;
import com.Crisalis.demo.model.Impuesto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImpuestoDTO {

    @JsonProperty("id")
    private Integer id;
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
