import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root',
})
export class AuthService {
    private loginUrl = 'http://localhost:8080/auth/login';  // URL para login
    private registerUrl = 'http://localhost:8080/auth/register'; // URL para registro

    constructor(private http: HttpClient) {}

    // Método para fazer o login
    login(authDTO: any): Observable<any> {
        return this.http.post(this.loginUrl, authDTO);
    }

    // Método para registrar um novo usuário
    register(registerDTO: any): Observable<any> {
        return this.http.post(this.registerUrl, registerDTO);
    }
}
