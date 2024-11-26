import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Cadastro1RoutingModule } from './cadastro1-routing.module';
import { Cadastro1Component } from './cadastro1.component';
import { ButtonModule } from 'primeng/button';
import { CheckboxModule } from 'primeng/checkbox';
import { FormsModule } from '@angular/forms';
import { PasswordModule } from 'primeng/password';
import { InputTextModule } from 'primeng/inputtext';
import { InputMaskModule } from 'primeng/inputmask';

@NgModule({
    imports: [
        CommonModule,
        Cadastro1RoutingModule,
        ButtonModule,
        CheckboxModule,
        InputTextModule,
        FormsModule,
        PasswordModule,
        InputMaskModule
    ],
    declarations: [Cadastro1Component]
})
export class Cadastro1Module { }
