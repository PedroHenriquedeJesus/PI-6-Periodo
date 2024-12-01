import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { FinalizacaoComponent } from './finalizacao.component';

@NgModule({
    imports: [RouterModule.forChild([
        { path: '', component: FinalizacaoComponent }
    ])],
    exports: [RouterModule]
})
export class FinalizacaoRoutingModule { }
