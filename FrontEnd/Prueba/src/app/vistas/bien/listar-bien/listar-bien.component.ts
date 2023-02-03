import { Component, OnInit } from '@angular/core';
import { Bien } from 'src/app/models/bien';
import { Cliente } from 'src/app/models/cliente';
import { BienService } from 'src/app/service/bien.service';
import { ClienteService } from 'src/app/service/cliente.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-listar-bien',
  templateUrl: './listar-bien.component.html',
  styleUrls: ['./listar-bien.component.css']
})
export class ListarBienComponent implements OnInit {

  bien!: Bien[];

  cliente: Cliente[] = [];

  constructor(
    private service: BienService,
    private clienteService: ClienteService,
    private router:Router) { }

  ngOnInit(): void{
    this.service.getBien().subscribe(data=>{
      this.bien=data;
    })
  }

  Editar(bien:Bien):void{
    localStorage.setItem("id",bien.id!.toString());
    this.router.navigate(["editar-bien"]);
  }

  Delete(bien:Bien){
    this.service.deleteBien(bien).subscribe(data=>{
      this.bien=this.bien?.filter(b=>b!==bien);
      alert("Bien eliminado!!!")
    })
  }
  Volver(){
    this.router.navigate(["proyecto"])
  }
  Crear(){
    this.router.navigate(["crear-bien"])
  }
}
