import { Component } from '@angular/core';
import {Router} from '@angular/router';
import { LayoutService } from 'src/app/layout/service/app.layout.service';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { RegisterService } from 'src/app/services/register.service.ts';

@Component({
    selector: 'app-cadastro1',
    templateUrl: './cadastro1.component.html',
    styles: [
        :host ::ng-deep .pi-eye,
        :host ::ng-deep .pi-eye-slash {
            transform:scale(1.6);
            margin-right: 1rem;
            color: var(--primary-color) !important;
        }
    ]
})
export class Cadastro1Component {

    email: string = '';
    senha: string = '';
    cpf: string = '';
    telefone: string = '';
    role: string = 'user';
    nome: string = '';

    constructor(public layoutService: LayoutService, private registerService: RegisterService, private router: Router) { }

    cadastro1() {
        const registerDTO = {email:this.email, senha:this.senha, cpf:this.cpf, telefone:this.telefone, role:"user", nome:this.nome}
        this.router.navigate(['./auth/login.module']);
    }

    this.registerService.enviarDados(registerDTO).subscribe(response => {
        console.log('Dados enviados com sucesso', response);
        // Limpar os campos do formulário
        this.email = '';
        this.senha = '';
        this.cpf = '';
        this.telefone = '';
        this.nome = '';

      }, error => {
        console.error('Erro ao enviar dados', error);
      });
    } else {
      console.log('Formulário inválido');
    }
  }}
