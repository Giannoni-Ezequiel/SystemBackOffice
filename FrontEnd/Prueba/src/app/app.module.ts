import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule, RoutingComponents } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './vistas/header/header.component';
import { FooterComponent } from './vistas/footer/footer.component';
import { LogoComponent } from './vistas/logo/logo.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { BannerComponent } from './vistas/banner/banner.component';
import { BodyComponent } from './vistas/body/body.component';
import { ListarComponent } from './vistas/cliente/listar/listar.component';
import { CrearComponent } from './vistas/cliente/crear/crear.component';
import { EditarComponent } from './vistas/cliente/editar/editar.component';
import { ClienteService } from './service/cliente.service';
import { CrearUsuariosComponent } from './vistas/usuario/crear-usuarios/crear-usuarios.component';
import { EditarUsuariosComponent } from './vistas/usuario/editar-usuarios/editar-usuarios.component';
import { ListarUsuariosComponent } from './vistas/usuario/listar-usuarios/listar-usuarios.component';
import { BienService } from './service/bien.service';
import { PedidoService } from './service/pedido.service';
import { RegistrationService } from './service/registration.service';
import { UsuarioService } from './service/usuario.service';
import { ListarBienComponent } from './vistas/bien/listar-bien/listar-bien.component';
import { CrearBienComponent } from './vistas/bien/crear-bien/crear-bien.component';
import { EditarBienComponent } from './vistas/bien/editar-bien/editar-bien.component';
import { ListarImpuestoComponent } from './vistas/impuesto/listar-impuesto/listar-impuesto.component';
import { CrearImpuestoComponent } from './vistas/impuesto/crear-impuesto/crear-impuesto.component';
import { EditarImpuestoComponent } from './vistas/impuesto/editar-impuesto/editar-impuesto.component';
import { ImpuestoService } from './service/impuesto.service';
import { ListarPedidoComponent } from './vistas/pedido/listar-pedido/listar-pedido.component';
import { CrearPedidoComponent } from './vistas/pedido/crear-pedido/crear-pedido.component';
import { EditarPedidoComponent } from './vistas/pedido/editar-pedido/editar-pedido.component';
import { ListarDetalleComponent } from './vistas/detalle/listar-detalle/listar-detalle.component';
import { CrearDetalleComponent } from './vistas/detalle/crear-detalle/crear-detalle.component';
import { EditarDetalleComponent } from './vistas/detalle/editar-detalle/editar-detalle.component';
import { DetalleService } from './service/detalle.service';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { MatMenuModule } from '@angular/material/menu';
import { MatDatepickerModule } from '@angular/material/datepicker';
//import { MatMomentDateModule } from '@angular/material-moment-adapter';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatNativeDateModule } from '@angular/material/core';
import {MatGridListModule} from '@angular/material/grid-list';
@NgModule({
  declarations: [
    AppComponent,
    RoutingComponents,
    HeaderComponent,
    FooterComponent,
    LogoComponent,
    BannerComponent,
    BodyComponent,
    ListarComponent,
    CrearComponent,
    EditarComponent,
    CrearUsuariosComponent,
    EditarUsuariosComponent,
    ListarUsuariosComponent,
    ListarBienComponent,
    CrearBienComponent,
    EditarBienComponent,
    ListarImpuestoComponent,
    CrearImpuestoComponent,
    EditarImpuestoComponent,
    ListarPedidoComponent,
    CrearPedidoComponent,
    EditarPedidoComponent,
    ListarDetalleComponent,
    CrearDetalleComponent,
    EditarDetalleComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule, FormsModule, NgbModule,
    BrowserAnimationsModule, MatMenuModule, MatDatepickerModule,
    MatNativeDateModule, MatGridListModule,//MatMomentDateModule,
  ],
  providers: [ClienteService, BienService, PedidoService,
    RegistrationService, UsuarioService, ImpuestoService, DetalleService],
  bootstrap: [AppComponent]
})
export class AppModule { }
