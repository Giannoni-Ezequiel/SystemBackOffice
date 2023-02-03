package com.Crisalis.demo.controller;

import com.Crisalis.demo.model.DTO.UserDTO;
import com.Crisalis.demo.model.Usuario;
import com.Crisalis.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;
    @Autowired
    private UsuarioController(UsuarioService usuarioService)
    {
        this.usuarioService = usuarioService;
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Usuario saveUser(@RequestBody UserDTO userDTO)
    {
        return this.usuarioService.saveUser(userDTO);
    }

    @GetMapping(value ="login", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO loginUserWithCredentials(@RequestParam String username, @RequestParam String password)
    {
        return this.usuarioService.loginUserWithCredentials(username, password);
    }

    @GetMapping(value = "list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> getAllUsers(){
        return this.usuarioService.getListAllUsersInBD();
    }
    @GetMapping(path = {"/{id}"})
    public Usuario listarId(@PathVariable("id")Integer id){
        return this.usuarioService.listarId(id);
    }
    @PostMapping(value = "add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Usuario add(@RequestBody UserDTO user)
    {
        return this.usuarioService.add(user);
    }
    @PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void editar(@RequestBody UserDTO user, @PathVariable("id")Integer id){
        user.setId(id);
        this.usuarioService.edit(user);
    }
    @DeleteMapping(path = {"/{id}"})
    public void delete(@PathVariable("id")Integer id)
    {
        this.usuarioService.delete(id);
    }


}
