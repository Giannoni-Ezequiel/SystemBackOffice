import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BienService } from 'src/app/service/bien.service';
import { Bien } from 'src/app/models/bien';

@Component({
  selector: 'app-crear-bien',
  templateUrl: './crear-bien.component.html',
  styleUrls: ['./crear-bien.component.css']
})

export class CrearBienComponent implements OnInit{

  bien:Bien;
  constructor(private router:Router, private service:BienService){
    this.bien = {
      nombre: "string",
      costo: 0,
      cargoSoporte: 0,
      esEspecial: false,
      porcentajeCarg: 0
    }
  }

  ngOnInit() {
  }

  Crear(bien:Bien){
    this.service.crearBien(bien).subscribe(data=>{
      alert("Se agrego con exito!!!");
      this.router.navigate(["listar-bien"]);
    })
  }

  Volver(){
    this.router.navigate(["listar-bien"])
  }

}
