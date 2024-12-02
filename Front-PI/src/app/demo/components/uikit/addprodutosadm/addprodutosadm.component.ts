import { Component } from '@angular/core';

@Component({
    templateUrl: './addprodutosadm.component.html'
})
export class AddprodutosadmComponent {
    product: any = {
        name: '',
        description: '',
        price: 0,
        image: null
    };

    onFileSelect(event: Event) {
        const input = event.target as HTMLInputElement;
        if (input.files && input.files[0]) {
            const reader = new FileReader();
            reader.onload = () => {
                this.product.image = reader.result; // Salva a imagem como base64 (ou manipule conforme necessário)
            };
            reader.readAsDataURL(input.files[0]);
        }
    }

    onSubmit(form: any) {
        if (form.valid) {
            console.log('Produto salvo:', this.product);
            // Lógica para salvar o produto
        }
    }
}
