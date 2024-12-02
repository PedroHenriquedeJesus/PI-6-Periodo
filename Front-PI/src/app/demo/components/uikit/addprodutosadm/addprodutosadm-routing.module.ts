import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AddprodutosadmComponent } from './addprodutosadm.component';

@NgModule({
    imports: [RouterModule.forChild([
        { path: '', component: AddprodutosadmComponent }
    ])],
    exports: [RouterModule]
})
export class AddprodutosadmRoutingModule { }
