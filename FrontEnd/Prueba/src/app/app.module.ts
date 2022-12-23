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
    BodyComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule, FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
