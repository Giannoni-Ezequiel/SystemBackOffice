import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './vistas/login/login.component';
import { ProyectoComponent } from './vistas/proyecto/proyecto.component';

const routes: Routes =
[
  {path: '', redirectTo: 'login', pathMatch:'full'},
  {path:'login', component: LoginComponent},
  {path:'proyecto', component: ProyectoComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const RoutingComponents = [LoginComponent, ProyectoComponent]
