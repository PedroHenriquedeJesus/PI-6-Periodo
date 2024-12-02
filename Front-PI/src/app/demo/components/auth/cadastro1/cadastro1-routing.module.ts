import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { Cadastro1Component } from './cadastro1.component';

@NgModule({
    imports: [RouterModule.forChild([
        { path: '', component: Cadastro1Component }
    ])],
    exports: [RouterModule]
})
export class Cadastro1RoutingModule { }
