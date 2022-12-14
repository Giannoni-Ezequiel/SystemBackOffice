package com.Crisalis.demo.controller;

import com.Crisalis.demo.model.DTO.UserDTO;
import com.Crisalis.demo.model.Usuario;
import com.Crisalis.demo.service.UsuarioService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

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
