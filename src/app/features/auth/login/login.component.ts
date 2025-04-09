import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-login',
  imports: [CommonModule, FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  credentials = {
    email: '',
    password: ''
  };

  errorMessage = '';

  onLogin() {
    if (!this.credentials.email || !this.credentials.password) {
      this.errorMessage = 'Por favor, completa todos los campos.';
    } else if (!this.credentials.email.includes('@')) {
      this.errorMessage = 'El email no tiene un formato válido.';
    } else {
      this.errorMessage = '';
      console.log('Credenciales ingresadas:', this.credentials);
      // Aquí podrías redirigir al listado, guardar sesión, etc.
    }
  }
}

