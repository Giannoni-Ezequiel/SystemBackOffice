package com.Administracion.Crisalis.controller;


import com.Administracion.Crisalis.model.DTO.UserDTO;
import com.Administracion.Crisalis.model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.Administracion.Crisalis.service.UsuarioService;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;
    @Autowired
    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }
    /*@GetMapping
    @PutMapping

    }*/

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Usuario saveUser(@RequestBody UserDTO userDTO){
        return this.usuarioService.saveUser(userDTO);
    }

    @GetMapping(value ="login", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO loginUser(@RequestParam String username, @RequestParam String password){
        return this.usuarioService.loginUserWithCredentials(username, password);
    }

}
