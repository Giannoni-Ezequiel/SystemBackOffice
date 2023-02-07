import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ImpuestoService } from 'src/app/service/impuesto.service';
import { Impuesto } from 'src/app/models/impuesto';

@Component({
  selector: 'app-listar-impuesto',
  templateUrl: './listar-impuesto.component.html',
  styleUrls: ['./listar-impuesto.component.css']
})
export class ListarImpuestoComponent implements OnInit{

  impuestos:Impuesto[] = [];

  constructor(
    private service:ImpuestoService,
    private router:Router)
    {}

  ngOnInit(): void{
    this.service.getImpuesto().subscribe(data=>{
      this.impuestos=data;
    })
  }

  Editar(impuesto:Impuesto):void{
    localStorage.setItem("id",impuesto.id!.toString());
    this.router.navigate(["editar-impuesto"]);
  }

  Delete(impuesto:Impuesto){
    this.service.deleteImpuesto(impuesto).subscribe(data=>{
      this.impuestos=this.impuestos?.filter(i=>i!==impuesto);
      alert("Impuesto eliminado!!!")
    })
  }

  Volver(){
    this.router.navigate(["proyecto"])
  }
  Crear(){
    this.router.navigate(["crear-impuesto"])
  }
}
