import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AddprodutosadmComponent } from './addprodutosadm.component';
import { AddprodutosadmRoutingModule } from './addprodutosadm-routing.module';
import { InputTextModule } from 'primeng/inputtext';
import { ButtonModule } from 'primeng/button';
import { InputTextareaModule } from 'primeng/inputtextarea';

@NgModule({
    imports: [
        CommonModule,
        FormsModule,
        AddprodutosadmRoutingModule,
        InputTextModule,
        ButtonModule,
        InputTextareaModule
    ],
    declarations: [AddprodutosadmComponent]
})
export class AddprodutosadmModule { }
