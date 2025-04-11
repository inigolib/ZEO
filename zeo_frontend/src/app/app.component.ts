import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { LoginComponent } from './features/auth/login/login.component';
import { AltaComponent } from './features/users/alta/alta.component';
import { ListadoComponent } from './features/users/listado/listado.component';
import { NavComponent } from './shared/nav/nav.component';

@Component({
  selector: 'app-root',
  imports: [
    RouterModule, 
    LoginComponent,
    AltaComponent,
    ListadoComponent,
    NavComponent
  ],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {}

