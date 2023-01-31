import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms'
import { LoginUsuario } from 'src/app/models/usuario';
import { RegistrationService } from 'src/app/service/registration.service';
import { Router } from '@angular/router'
import { ResponseI } from 'src/app/models/response.interface';
import { UsuarioService } from 'src/app/service/usuario.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {

  loginForm = new FormGroup
  ({
    usuario: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),
  })

  LoginUsuario!: LoginUsuario;
  nombreUsuario!: string;
  password!: string;
  name!: string;
  getData!: boolean;

  constructor(
    private registrationService: RegistrationService, 
    private router:Router,
    private usuarioService: UsuarioService){}

  ngOnInit(): void{}
  login()
  {
    this.usuarioService.getUserData(this.nombreUsuario,this.password).subscribe(res => {
      let getData = res;

      if(getData == true){
        this.router.navigate(["/proyecto"])
      }
    });
  }
  onLogin(): void
  {
    this.LoginUsuario = new LoginUsuario(this.nombreUsuario, this.password, this.name);
    this.registrationService.login(this.LoginUsuario).subscribe(data => {
      let dataResponse: ResponseI = data;
      if(dataResponse.status == "ok"){
        localStorage.setItem("token",dataResponse.result.token);
        this.router.navigate(['proyecto'])
      }
    });
    //this.registrationService.loginByEmail
  }

  
}
