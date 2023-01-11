import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ClienteService } from 'src/app/service/cliente.service';
import { Cliente } from 'src/app/models/cliente';
import {ModalDismissReasons, NgbModal} from '@ng-bootstrap/ng-bootstrap';
import { NgForm } from '@angular/forms';
@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})
export class ListarComponent implements OnInit{

  closeResult?: string;
  clientes:Cliente[] = [];

  constructor(
    private service:ClienteService,
    private router:Router,
    private modalService: NgbModal,
    ){}

  ngOnInit(){
    this.service.getClientes().subscribe(data=>{
      this.clientes=data;
    })
  }

  Editar(cliente:Cliente):void{
    localStorage.setItem("id",cliente.id!.toString());
    this.router.navigate(["editar"]);
  }

  Delete(cliente:Cliente){
    this.service.deleteCliente(cliente).subscribe(data=>{
      this.clientes=this.clientes?.filter(c=>c!==cliente);
      alert("Cliente eliminado!!!")

    })
  }

  Volver(){
    this.router.navigate(["proyecto"])
  }
  Crear(){
    this.router.navigate(["crear"])
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
