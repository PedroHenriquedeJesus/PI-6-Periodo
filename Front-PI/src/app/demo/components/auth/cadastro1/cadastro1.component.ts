import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LayoutService } from 'src/app/layout/service/app.layout.service';
import { RegisterService } from 'src/app/services/register.service';

@Component({
    selector: 'app-cadastro1',
    templateUrl: './cadastro1.component.html',
    styles: [`
        :host ::ng-deep .pi-eye,
        :host ::ng-deep .pi-eye-slash {
            transform:scale(1.6);
            margin-right: 1rem;
            color: var(--primary-color) !important;
        }
    `]
})
export class Cadastro1Component {

    email: string = '';
    senha: string = '';
    senhaConfirm: string = '';  // Campo para confirmação de senha
    cpf: string = '';
    telefone: string = '';
    role: string = 'user';  // A role sempre será 'user'
    nome: string = '';

    constructor(
        public layoutService: LayoutService,
        private registerService: RegisterService,
        private router: Router
    ) { }

    cadastro1() {
        // Verificar se as senhas coincidem
        if (this.senha !== this.senhaConfirm) {
            alert('As senhas não coincidem!');
            return;
        }

        const registerDTO = {
            email: this.email,
            senha: this.senha,
            CPF: this.cpf,
            telefone: this.telefone,
            role: this.role,  // A role será sempre 'user'
            nome: this.nome
        };

        this.registerService.enviarDados(registerDTO).subscribe(
            response => {
                console.log('Dados enviados com sucesso', response);
                // Limpar os campos do formulário
                this.email = '';
                this.senha = '';
                this.senhaConfirm = '';
                this.cpf = '';
                this.telefone = '';
                this.nome = '';
                // Redirecionar para o login
                this.router.navigate(['./auth/login']);
            },
            error => {
                console.error('Erro ao enviar dados', error);
            }
        );
    }
}
