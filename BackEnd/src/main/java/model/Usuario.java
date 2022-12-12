package com.Administracion.Crisalis.model;


import javax.persistence.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import com.Administracion.Crisalis.model.DTO.UserDTO;
import org.hibernate.annotations.Table;
import org.springframework.data.annotation.Id;

import javax.persistence.*;


@Entity
@Table(name = "Usuario")
@Data
@AllArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "username")
    private String username;
    @Column(name = "pass")
    private String password;
    @Column(name = "name")
    private String name;

    public Usuario(UserDTO userDTO){
        this.name = userDTO.getName();
        this.username = userDTO.getUsername();
        this.password = userDTO.getPassword();
    }

    public UserDTO toDTO(){
        return
                UserDTO
                        .builder()
                        .name(this.name)
                        .username(this.username)
                        .password(this.password)
                        .build();
    }
}
