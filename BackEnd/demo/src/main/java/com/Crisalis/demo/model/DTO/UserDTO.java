package com.Crisalis.demo.model.DTO;

import com.Crisalis.demo.model.UserRol;
import com.Crisalis.demo.model.Usuario;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    private String password;
    @JsonProperty("rol")
    private UserRol rol;

    public Usuario toUsuarioEntity(){
        return new Usuario(this.id, this.name, this.username, this.password
        , this.rol);
    }
}
