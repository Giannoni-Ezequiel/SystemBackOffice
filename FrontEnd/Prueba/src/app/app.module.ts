import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule, RoutingComponents } from './app-routing.module';
import { AppComponent } from './app.component';
import { BienComponent } from './vistas/bien/bien.component';
import { HeaderComponent } from './vistas/header/header.component';
import { FooterComponent } from './vistas/footer/footer.component';
import { LogoComponent } from './vistas/logo/logo.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { BannerComponent } from './vistas/banner/banner.component';
import { BodyComponent } from './vistas/body/body.component';
import { ListarComponent } from './vistas/cliente/listar/listar.component';
import { CrearComponent } from './vistas/cliente/crear/crear.component';
import { EditarComponent } from './vistas/cliente/editar/editar.component';
import { ServiceService } from './service/service.service';
import { CrearUsuariosComponent } from './vistas/usuario/crear-usuarios/crear-usuarios.component';
import { EditarUsuariosComponent } from './vistas/usuario/editar-usuarios/editar-usuarios.component';
import { ListarUsuariosComponent } from './vistas/usuario/listar-usuarios/listar-usuarios.component';

@NgModule({
  declarations: [
    AppComponent,
    BienComponent,
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
    ListarUsuariosComponent
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
