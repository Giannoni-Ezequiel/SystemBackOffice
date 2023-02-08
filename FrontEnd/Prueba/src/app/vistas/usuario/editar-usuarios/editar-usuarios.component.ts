import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UsuarioService } from 'src/app/service/usuario.service';
import { LoginUsuario } from 'src/app/models/loginusuario';

@Component({
  selector: 'app-editar-usuarios',
  templateUrl: './editar-usuarios.component.html',
  styleUrls: ['./editar-usuarios.component.css']
})
export class EditarUsuariosComponent implements OnInit{

  usuario!: LoginUsuario;
  constructor(private router:Router,
     private activatedRouter: ActivatedRoute,
     private service:UsuarioService){
    /*this.usuario = {
      nombreUsuario : '',
      password : '',
      name : '',
    }*/
  }

  ngOnInit(){
    const id = this.activatedRouter.snapshot.params['id'];
  }

  Editar(){
    let id=localStorage.getItem("id");
    this.service.getUsuariosId(id).subscribe(data=>{
      this.usuario=data;
    })
  }

  Actualizar(){
    const id = this.activatedRouter.snapshot.params['id'];
    this.service.updateUsuarios(id, this.usuario).subscribe(data=>{
      this.usuario = data;
      alert("Se actualizo correctamente!!!");
      this.router.navigate(["listar-usuarios"])
    })
  }

  Volver(){
    this.router.navigate(["listar-usuarios"])
  }
}
