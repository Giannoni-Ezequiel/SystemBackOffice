import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ImpuestoService } from 'src/app/service/impuesto.service';
import { Impuesto } from 'src/app/models/impuesto';
import { Bien } from 'src/app/models/bien';

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
      bien: new Bien(1,'',1,1,true,1,1,1),
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
    this.router.navigate(["listar-impuesto"])
  }
}
