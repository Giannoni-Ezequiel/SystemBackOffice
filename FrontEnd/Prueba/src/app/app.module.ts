import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule, RoutingComponents } from './app-routing.module';
import { AppComponent } from './app.component';
import { BienComponent } from './vistas/bien/bien.component';
import { PedidoComponent } from './vistas/pedido/pedido.component';
import { HeaderComponent } from './vistas/header/header.component';
import { FooterComponent } from './vistas/footer/footer.component';
import { LogoComponent } from './vistas/logo/logo.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { ServicioComponent } from './vistas/servicio/servicio.component';
import { BannerComponent } from './vistas/banner/banner.component';
import { BodyComponent } from './vistas/body/body.component';
import { ListarComponent } from './vistas/cliente/listar/listar.component';
import { CrearComponent } from './vistas/cliente/crear/crear.component';
import { EditarComponent } from './vistas/cliente/editar/editar.component';
import { ServiceService } from './service/service.service';

@NgModule({
  declarations: [
    AppComponent,
    BienComponent,
    PedidoComponent,
    RoutingComponents,
    HeaderComponent,
    FooterComponent,
    LogoComponent,
    ServicioComponent,
    BannerComponent,
    BodyComponent,
    ListarComponent,
    CrearComponent,
    EditarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule, FormsModule
  ],
  providers: [ServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
