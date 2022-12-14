import { Component, OnInit } from '@angular/core';

import { FormGroup, FormControl, Validators } from '@angular/forms'
import { LoginUsuario } from 'src/app/models/usuario';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {

  loginForm = new FormGroup({
    usuario: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),

  })
  LoginUsuario!: LoginUsuario;
  nombreUsuario!: string;
  password!: string

  constructor(){}

  ngOnInit(): void{}

  onLogin(): void{
    this.LoginUsuario = new LoginUsuario(this.nombreUsuario, this.password);
  }

}
