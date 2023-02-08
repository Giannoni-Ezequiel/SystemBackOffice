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

  name!: string;
  username!: string;
  password!: string;
  rol!: string;
  constructor(private router:Router, private service:UsuarioService){
    /*this.usuario = {
      nombreUsuario : '',
      password : '',
      name : '',
    }*/
  }

  ngOnInit(): void {
  }

  Crear(): void {
    const service = new LoginUsuario(this.name, this.username, this.password, this.rol);
    this.service.crearUsuarios(service).subscribe(data=>{
      alert("Se agrego con exito!!!");
      this.router.navigate(["listar-usuarios"]);
    }, err =>{
      alert("Fallo al agregar usuario");
      this.router.navigate(["listar-usuarios"]);
    })
  }

  Volver(){
    this.router.navigate(["listar-usuarios"])
  }
}
