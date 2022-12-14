import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule, RoutingComponents } from './app-routing.module';
import { AppComponent } from './app.component';
import { ClienteComponent } from './vistas/cliente/cliente.component';
import { BienComponent } from './vistas/bien/bien.component';
import { PedidoComponent } from './vistas/pedido/pedido.component';
import { HeaderComponent } from './vistas/header/header.component';
import { FooterComponent } from './vistas/footer/footer.component';
import { LogoComponent } from './vistas/logo/logo.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    ClienteComponent,
    BienComponent,
    PedidoComponent,
    RoutingComponents,
    HeaderComponent,
    FooterComponent,
    LogoComponent
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
