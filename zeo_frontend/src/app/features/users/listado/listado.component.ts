import { Component, OnInit } from '@angular/core';
import { ApiService } from '/Users/inigoliberal/zeo/zeo_frontend/src/app/services/api.service';
import { NgIf } from '@angular/common';
import { CommonModule } from '@angular/common';
import { finalize } from 'rxjs/operators';

@Component({
  selector: 'app-listado',
  imports: [NgIf, CommonModule],
  templateUrl: './listado.component.html',
  styleUrls: ['./listado.component.css'],

})
export class ListadoComponent implements OnInit {
  usuarios: any[] = [];
  errorMessage: string = '';
  loading: boolean = false;

  constructor(private apiService: ApiService) {}

  ngOnInit() {
    this.obtenerUsuarios();
  }

  obtenerUsuarios() {
    this.loading = true;
    
    this.apiService.getUsers().pipe(
      finalize(() => this.loading = false)
    ).subscribe({
      next: (data) => {
        this.usuarios = data;
        this.errorMessage = '';
      },
      error: (error) => {
        this.errorMessage = 'Hubo un error al cargar los usuarios.';
        this.usuarios = [];
        console.error('Error obteniendo usuarios:', error);
      }
    });
  }
}
