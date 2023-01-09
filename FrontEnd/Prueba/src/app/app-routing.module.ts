import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './vistas/login/login.component';
import { ProyectoComponent } from './vistas/proyecto/proyecto.component';
import { ListarComponent } from './vistas/cliente/listar/listar.component';
import { CrearComponent } from './vistas/cliente/crear/crear.component';
import { EditarComponent } from './vistas/cliente/editar/editar.component';
import { CrearUsuariosComponent } from './vistas/usuario/crear-usuarios/crear-usuarios.component';
import { EditarUsuariosComponent } from './vistas/usuario/editar-usuarios/editar-usuarios.component';
import { ListarUsuariosComponent } from './vistas/usuario/listar-usuarios/listar-usuarios.component';


const routes: Routes =
[
  {path: '', redirectTo: 'login', pathMatch:'full'},
  {path:'login', component: LoginComponent},
  {path:'proyecto', component: ProyectoComponent},
  {path:'listar', component: ListarComponent},
  {path:'crear', component: CrearComponent},
  {path:'editar', component: EditarComponent},
  //{path: 'impuesto', component: ImpuestoComponent}
  //{path: 'pedido', component: PedidoComponent}
  //{path: 'producto', component: ProductoComponent}
  {path:'crear-usuarios', component: CrearUsuariosComponent},
  {path:'editar-usuarios', component: EditarUsuariosComponent},
  {path:'listar-usuarios', component: ListarUsuariosComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const RoutingComponents = [LoginComponent, ProyectoComponent, ListarComponent, ListarUsuariosComponent]
