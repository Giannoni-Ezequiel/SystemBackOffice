package com.Crisalis.demo.model;

import com.Crisalis.demo.model.DTO.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
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
