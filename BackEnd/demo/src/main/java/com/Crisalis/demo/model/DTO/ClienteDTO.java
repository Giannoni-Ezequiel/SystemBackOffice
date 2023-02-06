package com.Crisalis.demo.model.DTO;

import com.Crisalis.demo.model.Empresa;
import com.Crisalis.demo.model.Person;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("tipo")
    private String tipo;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("apellido")
    private String apellido;
    @JsonProperty("DNI")
    private Integer DNI;
    @JsonProperty("email")
    private String email;
    @JsonProperty("direccion")
    private String direccion;
    @JsonProperty("telefono")
    private String telefono;
    @JsonProperty("razon_social")
    private String razonSocial;
    @JsonProperty("cuit")
    private String CUIT;

    @JsonProperty("fecha_de_inicio")
    private LocalDate fechadeinicio;
    private Person persona;

    public Person toPersonEntity(){
        return new Person(this.nombre, this.apellido, this.DNI ,this.email,this.direccion, this.telefono  );
    }
    public Empresa toEmpresaEntity(){
        return new Empresa(this.razonSocial, this.CUIT,  this.fechadeinicio, this.email, this.direccion,
                this.telefono, this.persona);
    }

}
