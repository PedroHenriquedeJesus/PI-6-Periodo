import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ButtonModule } from 'primeng/button';
import { CheckboxModule } from 'primeng/checkbox';
import { FormsModule } from '@angular/forms';
import { InputTextModule } from 'primeng/inputtext';
import { FinalizacaoRoutingModule } from './finalizacao-routing.module';
import { FinalizacaoComponent } from './finalizacao.component';
import { InputMaskModule } from 'primeng/inputmask';
import { TableModule } from 'primeng/table';
import { GoogleMapsModule } from '@angular/google-maps';



@NgModule({
    imports: [
        CommonModule,
        FinalizacaoRoutingModule,
        CommonModule,
        ButtonModule,
        CheckboxModule,
        InputTextModule,
        FormsModule,
        InputMaskModule,
        TableModule,
        GoogleMapsModule

    ],
    declarations: [FinalizacaoComponent]
})
export class FinalizacaoModule { }
