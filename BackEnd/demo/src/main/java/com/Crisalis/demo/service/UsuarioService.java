package com.Crisalis.demo.service;

import com.Crisalis.demo.exception.custom.EmptyElementException;
import com.Crisalis.demo.exception.custom.NotCreatedException;
import com.Crisalis.demo.exception.custom.UnauthorizedException;
import com.Crisalis.demo.model.DTO.UserDTO;
import com.Crisalis.demo.model.Usuario;
import com.Crisalis.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


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
                throw new EmptyElementException("Name is empty");
            }
        }

        if(StringUtils.isEmpty(userDTO.getUsername())){
            throw new EmptyElementException("Username is empty");
        }
        if(StringUtils.isEmpty(userDTO.getPassword())){
            throw new EmptyElementException("Password is empty");
        }
        return Boolean.TRUE;
    }
}
