import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LayoutService } from 'src/app/layout/service/app.layout.service';
import { AuthService } from 'src/app/services/auth.service';  // Adicionando o serviço de autenticação

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styles: [
        `
        :host ::ng-deep .pi-eye,
        :host ::ng-deep .pi-eye-slash {
            transform: scale(1.6);
            margin-right: 1rem;
            color: var(--primary-color) !important;
        }
        `
    ]
})
export class LoginComponent {

    valCheck: string[] = ['remember'];
    email: string = '';  // Adicionando email
    password!: string;  // Senha

    constructor(
        public layoutService: LayoutService,
        private router: Router,
        private authService: AuthService  // Injetando o AuthService
    ) { }

    login() {
        // Criando o objeto DTO para enviar para o backend
        const loginDTO = {
            email: this.email,
            senha: this.password
        };

        // Chamando o serviço de login
        this.authService.login(loginDTO).subscribe(
            (response) => {
                // Se o login for bem-sucedido, podemos salvar o token ou qualquer outra coisa
                console.log('Login bem-sucedido', response);

                // Exemplo de como armazenar o token no localStorage
                localStorage.setItem('auth_token', response.token);

                // Navegar para a página principal ou dashboard após o login
                this.router.navigate(['/dashboard']);  // Ajuste para a página desejada
            },
            (error) => {
                console.error('Erro ao fazer login', error);
                alert('Credenciais inválidas!');
            }
        );
    }
}
