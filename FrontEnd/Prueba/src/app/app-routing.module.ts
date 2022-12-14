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
import { CrearBienComponent } from './vistas/bien/crear-bien/crear-bien.component';
import { EditarBienComponent } from './vistas/bien/editar-bien/editar-bien.component';
import { ListarBienComponent } from './vistas/bien/listar-bien/listar-bien.component';
import { CrearImpuestoComponent } from './vistas/impuesto/crear-impuesto/crear-impuesto.component';
import { EditarImpuestoComponent } from './vistas/impuesto/editar-impuesto/editar-impuesto.component';
import { ListarImpuestoComponent } from './vistas/impuesto/listar-impuesto/listar-impuesto.component';
import { EditarPedidoComponent } from './vistas/pedido/editar-pedido/editar-pedido.component';
import { CrearPedidoComponent } from './vistas/pedido/crear-pedido/crear-pedido.component';
import { ListarPedidoComponent } from './vistas/pedido/listar-pedido/listar-pedido.component';
import { CrearDetalleComponent } from './vistas/detalle/crear-detalle/crear-detalle.component';
import { EditarDetalleComponent } from './vistas/detalle/editar-detalle/editar-detalle.component';
import { ListarDetalleComponent } from './vistas/detalle/listar-detalle/listar-detalle.component';


const routes: Routes =
[
  // LOGIN/HOME
  {path: '', redirectTo: 'login', pathMatch:'full'},
  {path:'login', component: LoginComponent},
  {path:'proyecto', component: ProyectoComponent},

  // CLIENTES
  {path:'listar', component: ListarComponent},
  {path:'crear', component: CrearComponent},
  {path:'editar', component: EditarComponent},
  

  // USUARIOS
  {path:'crear-usuarios', component: CrearUsuariosComponent},
  {path:'editar-usuarios', component: EditarUsuariosComponent},
  {path:'listar-usuarios', component: ListarUsuariosComponent},

  // BIENES
  {path:'crear-bien', component: CrearBienComponent},
  {path:'editar-bien', component: EditarBienComponent},
  {path:'listar-bien', component: ListarBienComponent},

  // IMPUESTOS
  {path: 'crear-impuesto', component: CrearImpuestoComponent},
  {path: 'editar-impuesto', component: EditarImpuestoComponent},
  {path: 'listar-impuesto', component: ListarImpuestoComponent},
  
  // PEDIDO
  {path: 'crear-pedido', component: CrearPedidoComponent},
  {path: 'editar-pedido', component: EditarPedidoComponent},
  {path: 'listar-pedido', component: ListarPedidoComponent},

  // DETALLE
  {path: 'crear-detalle', component: CrearDetalleComponent},
  {path: 'editar-detalle', component: EditarDetalleComponent},
  {path: 'listar-detalle', component: ListarDetalleComponent}

  //{path: 'producto', component: ProductoComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const RoutingComponents = [LoginComponent, ProyectoComponent, ListarComponent, ListarUsuariosComponent]
