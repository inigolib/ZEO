import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';


@Component({
  selector: 'app-alta',
  imports: [CommonModule, FormsModule],
  templateUrl: './alta.component.html',
  styleUrl: './alta.component.css'
})
export class AltaComponent {
  usuario = {
    nombre: '',
    edad: null,
    email: '',
    contrasena: ''
  };

  onSubmit() {
    console.log('Usuario registrado:', this.usuario);
  }
}
