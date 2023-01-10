import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ClienteService } from 'src/app/service/cliente.service';
import { Cliente } from 'src/app/models/cliente';

@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})
export class ListarComponent implements OnInit{

  clientes:Cliente[] = [];
  constructor(private service:ClienteService, private router:Router){}

  ngOnInit(){
    this.service.getClientes().subscribe(data=>{
      this.clientes=data;
    })
  }

  Editar(cliente:Cliente):void{
    localStorage.setItem("id",cliente.id!.toString());
    this.router.navigate(["editar"]);
  }

  Delete(cliente:Cliente){
    this.service.deleteCliente(cliente).subscribe(data=>{
      this.clientes=this.clientes?.filter(c=>c!==cliente);
      alert("Cliente eliminado!!!")

    })
  }

  Volver(){
    this.router.navigate(["proyecto"])
  }
  Crear(){
    this.router.navigate(["crear"])
  }

}
