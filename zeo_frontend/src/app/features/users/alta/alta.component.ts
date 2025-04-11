import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ApiService } from '/Users/inigoliberal/zeo/zeo_frontend/src/app/services/api.service';  

@Component({
  selector: 'app-alta',
  imports: [CommonModule, FormsModule],
  templateUrl: './alta.component.html',
  styleUrls: ['./alta.component.css']
})
export class AltaComponent {
  usuario = {
    nombre: '',
    edad: 0,  // Inicializa con un valor numérico, no null
    email: '',
    contrasena: ''
  };

  errorMessage = '';
  successMessage = '';

  constructor(private apiService: ApiService) {}

  onSubmit() {
    if (!this.usuario.nombre || !this.usuario.email || !this.usuario.contrasena || this.usuario.edad == null) {
      this.errorMessage = 'Por favor, completa todos los campos.';
    } else {
      this.apiService.createUser(this.usuario).subscribe({
        next: (response: string) => {
          console.log('Respuesta del backend:', response);
      
          if (response === 'Usuario registrado') {
            this.successMessage = 'Usuario registrado con éxito!';
          } else {
            this.errorMessage = 'Hubo un error al registrar el usuario.';
          }
        },
        error: (error) => {
          console.error('Error', error);
          this.errorMessage = 'Error al conectarse con el servidor.';
        }
      });
    }
  }
}
