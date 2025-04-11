import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ApiService {
  private baseUrl = 'http://localhost:8080/api/usuarios'; // Asegúrate de que esta URL corresponda a tu API de backend

  constructor(private http: HttpClient) {}

  // Login
  login(user: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/login`, user);
  }

  // Alta de usuario
  createUser(usuario: { nombre: string; edad: number; email: string; contrasena: string }): Observable<any> {
    return this.http.post(`${this.baseUrl}/alta`, usuario);
  }

  // Listado de usuarios
  getUsers(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/listado`);
  }
}
