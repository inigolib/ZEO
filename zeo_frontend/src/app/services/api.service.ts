import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ApiService {
  private baseUrl = 'http://localhost:8080/api/usuarios';

  constructor(private http: HttpClient) {}

  // Login
  login(credentials: { email: string; contrasena: string }) {
    return this.http.post('http://localhost:8080/api/usuarios/login', credentials, {
      responseType: 'text'
    });
  }

  // Alta de usuario
  createUser(usuario: { nombre: string; edad: number; email: string; contrasena: string }): Observable<any> {
    return this.http.post(`${this.baseUrl}/alta`, usuario, {
      responseType: 'text'
    });
  }

  // Listado de usuarios
  getUsers(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/listado`);
  }
}
