import { Component, OnInit } from '@angular/core';
import { Bien } from 'src/app/models/bien';
import { BienService } from 'src/app/service/bien.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-listar-bien',
  templateUrl: './listar-bien.component.html',
  styleUrls: ['./listar-bien.component.css']
})
export class ListarBienComponent implements OnInit {

  bien!: Bien[];
  producto!: Bien[];
  servicio!: Bien[];

  constructor(
    private service: BienService,
    private router:Router) { }

  ngOnInit(): void{
    this.service.getBien().subscribe(data=>{
      this.bien=data;
    })
    this.getProducto();
    this.getServicio();
  }

  getProducto(){
    this.service.getProducto().subscribe(data=>{
      this.producto=data;
    })
  }

  getServicio(){
    this.service.getServicio().subscribe(data=>{
      this.servicio=data;
    })
  }

  Editar(bien:Bien){
    localStorage.setItem("id",bien.id!.toString());
    this.router.navigate(["editar-bien"]);
  }

  Delete(bien:Bien){
    if(window.confirm('¿Estas seguro de querer borrar?')){
      this.service.deleteBien(bien).subscribe(data=>{
      this.bien=this.bien?.filter(b=>b!==bien);
      alert("Bien eliminado!!!")
    })
    }

  }
  Volver(){
    this.router.navigate(["proyecto"])
  }
  Crear(){
    this.router.navigate(["crear-bien"])
  }
}
