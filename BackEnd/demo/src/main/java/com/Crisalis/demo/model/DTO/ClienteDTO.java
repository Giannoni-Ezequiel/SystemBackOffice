package com.Crisalis.demo.model.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ClienteDTO {

    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("direccion")
    private String direccion;
    @JsonProperty("telefono")
    private String telefono;
}
