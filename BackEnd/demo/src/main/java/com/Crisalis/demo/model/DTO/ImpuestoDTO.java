package com.Crisalis.demo.model.DTO;

import com.Crisalis.demo.model.Impuesto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImpuestoDTO {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("Nombre")
    private String imp_Nombre;
    @JsonProperty("Porcentaje")
    private BigDecimal imp_Porcentaje;

    public Impuesto toImpuestoEntity(){
        return new Impuesto(this.imp_Nombre, this.imp_Porcentaje);
    }

}
