import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClienteComponent } from './vistas/cliente/cliente.component';
import { LoginComponent } from './vistas/login/login.component';
import { ProyectoComponent } from './vistas/proyecto/proyecto.component';
import { ServicioComponent } from './vistas/servicio/servicio.component';
                //api

const routes: Routes =
[
  {path: '', redirectTo: 'login', pathMatch:'full'},
  {path:'login', component: LoginComponent},
  {path:'proyecto', component: ProyectoComponent},
  {path:'cliente', component: ClienteComponent},
  //{path: 'producto', component: ProductoComponent}
  {path: 'servicio', component: ServicioComponent},
  //{path: 'impuesto', component: ImpuestoComponent}
  //{path: 'pedido', component: PedidoComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const RoutingComponents = [LoginComponent, ProyectoComponent, ClienteComponent, ServicioComponent]
