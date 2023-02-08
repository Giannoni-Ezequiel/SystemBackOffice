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

  imp_Nombre!: string;
  imp_Porcentaje!: number;

  constructor(private router:Router, private service:ImpuestoService){

  }

  ngOnInit(): void {

  }

  Crear(): void{
    const impuesto = new Impuesto(this.imp_Nombre, this.imp_Porcentaje);
    this.service.crearImpuesto(impuesto).subscribe(data=>{
      alert("Se agrego con exito!!!");
      this.router.navigate(["listar-impuesto"]);
    })
  }

  Volver(): void{
    this.router.navigate(["listar-impuesto"])
  }
}
