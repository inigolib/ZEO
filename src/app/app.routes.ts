import { Routes } from '@angular/router';
import { LoginComponent } from './features/auth/login/login.component';
import { AltaComponent } from './features//users/alta/alta.component';
import { ListadoComponent } from './features/users/listado/listado.component';

export const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'alta', component: AltaComponent },
  { path: 'listado', component: ListadoComponent }
];