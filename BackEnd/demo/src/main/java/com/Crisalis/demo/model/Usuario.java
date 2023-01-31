package com.Crisalis.demo.model;

import com.Crisalis.demo.model.DTO.UserDTO;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Usuario")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

    @Column(name = "rol")
    private UserRol rol;

    public Usuario(UserDTO userDTO){
        this.name = userDTO.getName();
        this.username = userDTO.getUsername();
        this.password = userDTO.getPassword();
        this.rol = userDTO.getRol();
    }

    public UserDTO toDTO(){
        return
                UserDTO
                        .builder()
                        .name(this.name)
                        .username(this.username)
                        .password(this.password)
                        .rol(this.rol)
                        .build();
    }
}
