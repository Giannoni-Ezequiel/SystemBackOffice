import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ImpuestoService } from 'src/app/service/impuesto.service';
import { Impuesto } from 'src/app/models/impuesto';

@Component({
  selector: 'app-crear-impuesto',
  templateUrl: './crear-impuesto.component.html',
  styleUrls: ['./crear-impuesto.component.css']
})
export class CrearImpuestoComponent implements OnInit{

  impuesto:Impuesto;
  constructor(private router:Router, private service:ImpuestoService){
    this.impuesto = {
      porcentaje: 0,
      nombre: '',
    }
  }

  ngOnInit() {
  }

  Crear(impuesto:Impuesto){
    this.service.crearImpuesto(impuesto).subscribe(data=>{
      alert("Se agrego con exito!!!");
      this.router.navigate(["listar-impuesto"]);
    })
  }

  Volver(){
    this.router.navigate(["proyecto"])
  }
}
