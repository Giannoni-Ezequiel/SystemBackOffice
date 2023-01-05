import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClienteComponent } from './vistas/cliente/cliente.component';
import { LoginComponent } from './vistas/login/login.component';
import { ProyectoComponent } from './vistas/proyecto/proyecto.component';
import { ServicioComponent } from './vistas/servicio/servicio.component';
import { ListarComponent } from './vistas/cliente/listar/listar.component';
import { CrearComponent } from './vistas/cliente/crear/crear.component';
import { EditarComponent } from './vistas/cliente/editar/editar.component';
                //api

const routes: Routes =
[
  {path: '', redirectTo: 'login', pathMatch:'full'},
  {path:'login', component: LoginComponent},
  {path:'proyecto', component: ProyectoComponent},
  {path:'cliente', component: ClienteComponent},
  {path:'listar', component: ListarComponent},
  {path:'crear', component: CrearComponent},
  {path:'editar', component: EditarComponent},
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
