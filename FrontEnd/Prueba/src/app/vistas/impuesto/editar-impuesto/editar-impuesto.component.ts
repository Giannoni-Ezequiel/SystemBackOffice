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

  impuesto:Impuesto;
  constructor(private router:Router, private service:ImpuestoService){
    this.impuesto = {
      porcentaje: 0,
      nombre: '',
      bien: new Bien(1,'',1,1,true,1,1,1),
    }
  }

  ngOnInit(){
    this.Editar();
  }

  Editar(){
    let id=localStorage.getItem("id");
    this.service.getImpuestoId(id).subscribe(data=>{
      this.impuesto=data;
    })
  }

  Actualizar(impuesto:Impuesto){
    this.service.updateImpuesto(impuesto).subscribe(data=>{
      this.impuesto = data;
      alert("Se actualizo correctamente!!!");
      this.router.navigate(["listar-impuesto"])
    })
  }

  Volver(){
    this.router.navigate(["listar-impuesto"])
  }
}
