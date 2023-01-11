package com.Crisalis.demo.model;

import com.Crisalis.demo.model.DTO.ClienteDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DiscriminatorOptions;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Tipo")
@DiscriminatorOptions(force = true)
@Table(name = "Cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Cliente {

    @Id
    @SequenceGenerator(
            name = "cliente_sequence",
            sequenceName = "cliente_sequence",
            allocationSize = 1,
            initialValue = 0
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cliente_sequence"
    )
    @Column(name = "id")
    private Integer id;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono")
    private String telefono;

    @ManyToMany
    private List<Bien> bienList = new ArrayList<>();


    public Cliente(ClienteDTO clienteDTO){

        this.direccion = clienteDTO.getDireccion();
        this.telefono = clienteDTO.getTelefono();
    }

    public ClienteDTO toDTO(){
        return
                ClienteDTO
                        .builder()
                        .direccion(this.direccion)
                        .telefono(this.telefono)
                        .build();
    }
}