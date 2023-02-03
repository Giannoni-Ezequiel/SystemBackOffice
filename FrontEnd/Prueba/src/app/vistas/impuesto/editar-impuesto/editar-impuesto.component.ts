import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ImpuestoService } from 'src/app/service/impuesto.service';
import { Impuesto } from 'src/app/models/impuesto';
import { Bien } from 'src/app/models/bien';

@Component({
  selector: 'app-editar-impuesto',
  templateUrl: './editar-impuesto.component.html',
  styleUrls: ['./editar-impuesto.component.css']
})
export class EditarImpuestoComponent implements OnInit{

  impuesto!:Impuesto;

  constructor(
    private router:Router,
    private service:ImpuestoService)
    {
  }

  ngOnInit(): void{
    this.Editar();
  }

  Editar(): void{
    let id=localStorage.getItem("id");
    this.service.getImpuestoId(id).subscribe(data=>{
      this.impuesto=data;
    })
  }

  Actualizar(impuesto:Impuesto): void{
    this.service.updateImpuesto(impuesto).subscribe(data=>{
      this.impuesto = data;
      alert("Se actualizo correctamente!!!");
      this.router.navigate(["listar-impuesto"])
    })
  }

  Volver(): void{
    this.router.navigate(["listar-impuesto"])
  }
}
