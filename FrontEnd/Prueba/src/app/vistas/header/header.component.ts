import { Component } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {

  constructor(private router: Router) {}

  login(){
    this.router.navigate(['/login'])
  }

  cliente(){
    this.router.navigate(['/listar'])
  }

  usuario(){
    this.router.navigate(['/listar-usuarios'])
  }

  bien(){
    this.router.navigate(['/listar-bien'])
  }

  impuesto(){
    this.router.navigate(['/listar-impuesto'])
  }

  pedido(){
    this.router.navigate(['/listar-pedido'])
  }

  detalle(){
    this.router.navigate(['/listar-detalle'])
  }
}
