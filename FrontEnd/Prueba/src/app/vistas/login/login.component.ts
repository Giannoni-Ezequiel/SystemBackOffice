import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms'
import { LoginUsuario } from 'src/app/models/usuario';
import { RegistrationService } from 'src/app/service/registration.service';
import { Router } from '@angular/router'
import { ResponseI } from 'src/app/models/response.interface';

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
  password!: string

  constructor(private registrationService: RegistrationService, private router:Router){}

  ngOnInit(): void{}

  onLogin(form: LoginUsuario): void
  {
    this.LoginUsuario = new LoginUsuario(this.nombreUsuario, this.password);
    this.registrationService.login(this.LoginUsuario).subscribe(data => {
      let dataResponse: ResponseI = data;
      if(dataResponse.status == "ok"){
        //localStorage.setItem("token",dataResponse.result.token);
        this.router.navigate(['proyecto'])
      }
    });
    //this.registrationService.loginByEmail
  }

}
