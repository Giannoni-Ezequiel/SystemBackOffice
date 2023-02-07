import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BienService } from 'src/app/service/bien.service';
import { Bien } from 'src/app/models/bien';

@Component({
  selector: 'app-editar-bien',
  templateUrl: './editar-bien.component.html',
  styleUrls: ['./editar-bien.component.css']
})
export class EditarBienComponent implements OnInit{

  bien!:Bien;
  constructor(private router:Router, private service:BienService){
    /*this.bien = {
      nombre: "string",
      costo: 0,
      cargoSoporte: 0,
      esEspecial: false,
      garantia: 0,
      porcentajeGarantia: 0,
      clientes: [],
      impuestos: []
    }*/
  }

  ngOnInit(){
    this.Editar();
  }

  Editar(){
    let id=localStorage.getItem("id");
    this.service.getBienId(id).subscribe(data=>{
      this.bien=data;
    })
  }

  Actualizar(bien:Bien){
    this.service.updateBien(bien).subscribe(data=>{
      this.bien = data;
      alert("Se actualizo correctamente!!!");
      this.router.navigate(["listar-bien"])
    })
  }

  Volver(){
    this.router.navigate(["listar-bien"])
  }
}
