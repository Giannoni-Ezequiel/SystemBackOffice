package com.Crisalis.demo.model.DTO;

import com.Crisalis.demo.model.Bien;
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

}
