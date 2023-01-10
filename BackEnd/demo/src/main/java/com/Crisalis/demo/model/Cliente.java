package com.Crisalis.demo.model;

import com.Crisalis.demo.model.DTO.ClienteDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono")
    private String telefono;

    public Cliente(ClienteDTO clienteDTO){
        this.nombre = clienteDTO.getNombre();
        this.direccion = clienteDTO.getDireccion();
        this.telefono = clienteDTO.getTelefono();
    }

    public ClienteDTO toDTO(){
        return
                ClienteDTO
                        .builder()
                        .nombre(this.nombre)
                        .direccion(this.direccion)
                        .telefono(this.telefono)
                        .build();
    }
}

//