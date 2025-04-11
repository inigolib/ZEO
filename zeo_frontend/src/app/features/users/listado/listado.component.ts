import { Component, OnInit } from '@angular/core';
import { ApiService } from '/Users/inigoliberal/zeo/zeo_frontend/src/app/services/api.service';
import { NgIf } from '@angular/common';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-listado',
  imports: [NgIf, CommonModule],
  templateUrl: './listado.component.html',
  styleUrls: ['./listado.component.css'],
})
export class ListadoComponent implements OnInit {
  usuarios: any[] = [];
  errorMessage: string = '';

  constructor(private apiService: ApiService) {}

  ngOnInit() {
    this.obtenerUsuarios();
  }

  obtenerUsuarios() {
    this.apiService.getUsers().subscribe(
      (data) => {
        this.usuarios = data;
      },
      (error) => {
        this.errorMessage = 'Hubo un error al cargar los usuarios.';
        console.error(error);
      }
    );
  }
}
