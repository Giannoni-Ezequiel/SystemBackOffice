package com.Crisalis.demo.model.DTO;

import com.Crisalis.demo.model.Empresa;
import com.Crisalis.demo.model.Person;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;
import java.util.Optional;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    public ClienteDTO personaToDto (Optional<Person> persona) {
        return ClienteDTO.builder()
                .id(persona.get().getId())
                .nombre(persona.get().getNombre())
                .apellido(persona.get().getApellido())
                .DNI(persona.get().getDNI())
                .direccion(persona.get().getDireccion())
                .telefono(persona.get().getTelefono())
                .email(persona.get().getEmail())
                .tipo("Persona")
                .build();
    }
    public ClienteDTO personaToDtos (Person persona) {
        return ClienteDTO.builder()
                .id(persona.getId())
                .nombre(persona.getNombre())
                .apellido(persona.getApellido())
                .DNI(persona.getDNI())
                .direccion(persona.getDireccion())
                .telefono(persona.getTelefono())
                .email(persona.getEmail())
                .tipo("Persona")
                .build();
    }
    public Person toPersonEntity(){
        return new Person(this.nombre, this.apellido, this.DNI ,this.email,this.direccion, this.telefono  );
    }

    public ClienteDTO empresaToDto (Empresa empresa){
        return ClienteDTO.builder()
                .id(empresa.getId())
                .nombre(empresa.getRazonSocial())
                .fechadeinicio(empresa.getFechadeinicio())
                .CUIT(empresa.getCUIT())
                .direccion(empresa.getDireccion())
                .telefono(empresa.getTelefono())
                .email(empresa.getEmail())
                .tipo("Empresa")
                .nombre(empresa.getPersona().getNombre())
                .apellido(empresa.getPersona().getApellido())
                .DNI(empresa.getPersona().getDNI())
                .build();
    }
    public Empresa toEmpresaEntity(Person p){
        return new Empresa(this.razonSocial, this.CUIT,  this.fechadeinicio, this.email, this.direccion,
                this.telefono, p);
    }

}
