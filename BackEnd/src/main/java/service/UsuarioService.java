package com.Administracion.Crisalis.service;

import com.Administracion.Crisalis.exception.custom.EmptyElementExcepcion;
import com.Administracion.Crisalis.exception.custom.NotCreatedException;
import com.Administracion.Crisalis.exception.custom.UnauthorizedException;
import com.Administracion.Crisalis.model.DTO.UserDTO;
import com.Administracion.Crisalis.model.Usuario;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Administracion.Crisalis.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario saveUser(UserDTO userDTO){
        if(checkUserForSaveOrLogin(userDTO, Boolean.FALSE)){
            return this.usuarioRepository.save(new Usuario(userDTO));
        }
        throw new NotCreatedException("Error in save new user");
    }
    public UserDTO loginUserWithCredentials(String username, String password) {
        if(
                this.checkUserForSaveOrLogin(UserDTO
                            .builder()
                                .username(username)
                                .password(password)
                            .build()
                        , Boolean.TRUE)
        ){
            this.usuarioRepository.findByUsernameAndPassword(username, password)
                    .orElseThrow(
                            () -> new UnauthorizedException("Invalid credentials")
                    ).toDTO();
        }
        throw new UnauthorizedException("Invalid credentials");
    }
    private Boolean checkUserForSaveOrLogin(UserDTO userDTO, Boolean isForLogin){
        if(!isForLogin){
            if(StringUtils.isEmpty(userDTO.getName())){
                throw new EmptyElementExcepcion("Name is empty");
            }
        }

        if(StringUtils.isEmpty(userDTO.getUsername())){
            throw new EmptyElementExcepcion("Username is empty");
        }
        if(StringUtils.isEmpty(userDTO.getPassword())){
            throw new EmptyElementExcepcion("Password is empty");
        }
        return Boolean.TRUE;
    }
}
