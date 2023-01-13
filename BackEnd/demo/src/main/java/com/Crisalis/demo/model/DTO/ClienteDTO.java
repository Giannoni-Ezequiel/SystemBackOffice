package com.Crisalis.demo.model.DTO;

import com.Crisalis.demo.model.Empresa;
import com.Crisalis.demo.model.Person;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@Builder
public class ClienteDTO {


    @JsonProperty("tipo")
    private String tipo;
    @JsonProperty("direccion")
    private String direccion;
    @JsonProperty("telefono")
    private String telefono;
    @JsonProperty("DNI")
    private Integer DNI;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("apellido")
    private String apellido;
    @JsonProperty("email")
    private String email;
    @JsonProperty("cuit")
    private Integer CUIT;
    @JsonProperty("razon_social")
    private String razonSocial;
    @JsonProperty( "fecha_de_inicio")
    private Integer fechadeinicio;

    public Person toPersonEntity(){
        return new Person(this.direccion, this.telefono, this.DNI, this.nombre, this.apellido, this.email);
    }

    public Empresa toEmpresaEntity(){
        return new Empresa(this.direccion, this.telefono, this.CUIT, this.razonSocial, this.fechadeinicio);
    }
}
