import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { ProdutosadmComponent } from './produtosadm.component';

@NgModule({
	imports: [RouterModule.forChild([
		{ path: '', component: ProdutosadmComponent }
	])],
	exports: [RouterModule]
})
export class ProdutosadmRoutingModule { }
