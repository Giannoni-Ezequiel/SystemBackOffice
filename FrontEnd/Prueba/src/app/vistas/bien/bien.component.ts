import { Component, OnInit } from '@angular/core';
import { Bien } from 'src/app/models/bien';
import { Cliente } from 'src/app/models/cliente';
import { BienService } from 'src/app/service/bien.service';
import { ClienteService } from 'src/app/service/cliente.service';

@Component({
  selector: 'app-bien',
  templateUrl: './bien.component.html',
  styleUrls: ['./bien.component.css']
})
export class BienComponent implements OnInit {

  /*bien: Bien[];

  cliente: Cliente[];*/

  constructor(private bienService: BienService, private clienteService: ClienteService) { }

  ngOnInit() {
      /*this.bienService.getProductsSmall().then(data => this.products = data);
      this.clienteService.getCustomersLarge().then(customers => this.customers = customers);*/
  }
}
