import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ClienteService } from 'src/app/service/cliente.service';
import { Cliente } from 'src/app/models/cliente';
import {ModalDismissReasons, NgbModal} from '@ng-bootstrap/ng-bootstrap';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-crear',
  templateUrl: './crear.component.html',
  styleUrls: ['./crear.component.css']
})
export class CrearComponent implements OnInit {

  closeResult?: string;
  cliente!:Cliente;

  constructor(
    private router:Router,
    private service:ClienteService,
    private modalService: NgbModal,){
    /*this.cliente = {
      nombre : '',
      dni : '',
      apellido : '',
      img : '',
      razonSocial : '',
      email : '',
      direccion : '',
      cuit : '',
      telefono : '',
      fechaDeInicio : new Date,
    }*/
  }

  ngOnInit() {
  }

  Crear(cliente:Cliente){
    this.service.crearCliente(cliente).subscribe(data=>{
      alert("Se agrego con exito!!!");
      this.router.navigate(["listar"]);
    })
  }

  Volver(){
    this.router.navigate(["listar"])
  }

  open(content: any) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }

  onSubmit(f: NgForm) {
    this.service.crearCliente(f.value)
      .subscribe((result) => {
        this.ngOnInit(); //reload the table
      });
    this.modalService.dismissAll(); //dismiss the modal
  }
}
