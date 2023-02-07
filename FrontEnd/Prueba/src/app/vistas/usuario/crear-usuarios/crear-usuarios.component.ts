import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UsuarioService } from 'src/app/service/usuario.service';
import { LoginUsuario } from 'src/app/models/loginusuario';

@Component({
  selector: 'app-crear-usuarios',
  templateUrl: './crear-usuarios.component.html',
  styleUrls: ['./crear-usuarios.component.css']
})
export class CrearUsuariosComponent implements OnInit{

  usuario!:LoginUsuario;
  constructor(private router:Router, private service:UsuarioService){
    /*this.usuario = {
      nombreUsuario : '',
      password : '',
      name : '',
    }*/
  }

  ngOnInit() {
  }

  Crear(usuario:LoginUsuario){
    this.service.crearUsuarios(usuario).subscribe(data=>{
      alert("Se agrego con exito!!!");
      this.router.navigate(["listar-usuarios"]);
    })
  }

  Volver(){
    this.router.navigate(["listar-usuarios"])
  }
}
