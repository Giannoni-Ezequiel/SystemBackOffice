import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UsuarioService } from 'src/app/service/usuario.service';
import { LoginUsuario } from 'src/app/models/loginusuario';

@Component({
  selector: 'app-listar-usuarios',
  templateUrl: './listar-usuarios.component.html',
  styleUrls: ['./listar-usuarios.component.css']
})
export class ListarUsuariosComponent implements OnInit{

  usuarios:LoginUsuario[] = [];

  constructor(
    private usuario:UsuarioService,
    private router:Router)
    {}

  ngOnInit(): void{
    this.usuario.getUsuarios().subscribe(data=>{
      this.usuarios=data;
    })
  }

  Editar(usuarios:LoginUsuario):void{
    localStorage.setItem("id",usuarios.id!.toString());
    this.router.navigate(["editar-usuarios"]);
  }

  Delete(usuarios:LoginUsuario){
    if(window.confirm('¿Estas seguro de querer borrar?')){
    this.usuario.deleteUsuarios(usuarios).subscribe(data=>{
      this.usuarios=this.usuarios?.filter(u=>u!==usuarios);
      alert("Usuario eliminado!!!")
    })
  }
  }

  Volver(){
    this.router.navigate(["proyecto"])
  }
  Crear(){
    this.router.navigate(["crear-usuarios"])
  }

}
