import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UsuarioService } from 'src/app/service/usuario.service';
import { LoginUsuario } from 'src/app/models/usuario';

@Component({
  selector: 'app-editar-usuarios',
  templateUrl: './editar-usuarios.component.html',
  styleUrls: ['./editar-usuarios.component.css']
})
export class EditarUsuariosComponent implements OnInit{

  usuario:LoginUsuario;
  constructor(private router:Router, private service:UsuarioService){
    this.usuario = {
      nombreUsuario : '',
      password : '',
      name : '',
    }
  }

  ngOnInit(){
    this.Editar();
  }

  Editar(){
    let id=localStorage.getItem("id");
    this.service.getUsuariosId(id).subscribe(data=>{
      this.usuario=data;
    })
  }

  Actualizar(usuario:LoginUsuario){
    this.service.updateUsuarios(usuario).subscribe(data=>{
      this.usuario = data;
      alert("Se actualizo correctamente!!!");
      this.router.navigate(["listar-usuarios"])
    })
  }

  Volver(){
    this.router.navigate(["proyecto"])
  }
}
