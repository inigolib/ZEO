import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

import { ApiService } from '/Users/inigoliberal/zeo/zeo_frontend/src/app/services/api.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  imports: [CommonModule, FormsModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'] // Aquí debería ser styleUrls, no styleUrl
})
export class LoginComponent {
  credentials = {
    email: '',
    password: ''
  };

  errorMessage = '';

  constructor(private apiService: ApiService, private router: Router) {}

  onLogin() {
    if (!this.credentials.email || !this.credentials.password) {
      this.errorMessage = 'Por favor, completa todos los campos.';
    } else if (!this.credentials.email.includes('@')) {
      this.errorMessage = 'El email no tiene un formato válido.';
    } else {
      this.errorMessage = ''; // Limpiar mensaje de error si todo es válido
      console.log('Credenciales ingresadas:', this.credentials);

      // Llamar al método de login del ApiService
      this.apiService.login(this.credentials).subscribe(
        (response) => {
          console.log('Login exitoso', response);
          // Redirigir al listado de usuarios o donde necesites
          this.router.navigate(['/users']); // O la ruta que corresponda
        },
        (error) => {
          console.error('Error al hacer login', error);
          this.errorMessage = 'Credenciales incorrectas o error al iniciar sesión.';
        }
      );
    }
  }
}


