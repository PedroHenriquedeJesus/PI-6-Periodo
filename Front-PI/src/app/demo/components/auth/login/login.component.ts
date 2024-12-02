import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css'],
})
export class LoginComponent {
    email: string = '';
    senha: string = '';

    constructor(private authService: AuthService, private router: Router) {}

    login() {
        const loginDTO = {
            email: this.email,
            senha: this.senha,
        };

        this.authService.login(loginDTO).subscribe(
            (response) => {
                // Se login for bem-sucedido, você pode salvar o token ou qualquer outra coisa
                console.log('Login bem-sucedido', response);

                // Salve o token se necessário
                localStorage.setItem('auth_token', response.token);

                // Redireciona para a página inicial ou para onde for necessário
                this.router.navigate(['/dashboard']);
            },
            (error) => {
                console.error('Erro ao fazer login', error);
                alert('Credenciais inválidas!');
            }
        );
    }
}
