import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ProdutosadmComponent } from './produtosadm.component';
import { ProdutosadmRoutingModule } from './produtosadm-routing.module';
import { DataViewModule } from 'primeng/dataview';
import { PickListModule } from 'primeng/picklist';
import { OrderListModule } from 'primeng/orderlist';
import { InputTextModule } from 'primeng/inputtext';
import { DropdownModule } from 'primeng/dropdown';
import { RatingModule } from 'primeng/rating';
import { ButtonModule } from 'primeng/button';

@NgModule({
	imports: [
		CommonModule,
		FormsModule,
		ProdutosadmRoutingModule,
		DataViewModule,
		PickListModule,
		OrderListModule,
		InputTextModule,
		DropdownModule,
		RatingModule,
		ButtonModule
	],
	declarations: [ProdutosadmComponent]
})
export class ProdutosadmModule { }
