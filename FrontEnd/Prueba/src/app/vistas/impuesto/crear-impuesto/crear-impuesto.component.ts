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

  impuesto!:Impuesto;
  constructor(private router:Router, private service:ImpuestoService){
  }

  ngOnInit(): void {
  }

  Crear(impuesto:Impuesto): void{
    this.service.crearImpuesto(impuesto).subscribe(data=>{
      alert("Se agrego con exito!!!");
      this.router.navigate(["listar-impuesto"]);
    })
  }

  Volver(): void{
    this.router.navigate(["listar-impuesto"])
  }
}
