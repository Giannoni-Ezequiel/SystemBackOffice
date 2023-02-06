package com.Crisalis.demo.model;

//import com.Crisalis.demo.model.DTO.ClienteDTO;
import lombok.*;
import org.hibernate.annotations.DiscriminatorOptions;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Tipo")
@DiscriminatorOptions(force = true)
@Table(name = "cliente")
@Getter
@Setter
@ToString
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
    public Integer id;
    @Column(name = "email")
    public String email;
    @Column(name = "direccion")
    public String direccion;
    @Column(name = "telefono")
    public String telefono;
    /*
    @OneToMany
    @JoinColumn(name = "bien_ID")
    protected List<Bien> Bienes = new ArrayList<>();



    @ManyToMany
    private List<Bien> bienList = new ArrayList<>();*/

    /*
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
    }*/

    public Cliente() {
    }

    public Cliente(Integer id, String email, String direccion, String telefono) {
        this.id = id;
        this.email = email;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    /*public Cliente(Integer id, String email, String direccion, String telefono, List<Bien> bienes) {
        this.id = id;
        this.email = email;
        this.direccion = direccion;
        this.telefono = telefono;
        Bienes = bienes;
    }*/

    public Cliente(String email, String direccion, String telefono) {
    }

    public abstract Boolean esMayorDeEdad();
}