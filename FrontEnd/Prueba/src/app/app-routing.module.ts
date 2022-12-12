import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { ProyectoComponent } from './components/proyecto/proyecto.component';

const routes: Routes =
[
  {path:'', component: ProyectoComponent},
  {path:'login', component: LoginComponent},
  {path: '', redirectTo: 'login', pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
