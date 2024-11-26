import { Component } from '@angular/core';
import {Router} from '@angular/router';
import { LayoutService } from 'src/app/layout/service/app.layout.service';
import { RouterModule } from '@angular/router';

@Component({
    selector: 'app-cadastro1',
    templateUrl: './cadastro1.component.html',
    styles: [`
        :host ::ng-deep .pi-eye,
        :host ::ng-deep .pi-eye-slash {
            transform:scale(1.6);
            margin-right: 1rem;
            color: var(--primary-color) !important;
        }
    `]
})
export class Cadastro1Component {

    valCheck: string[] = ['remember'];

    password!: string;

    constructor(public layoutService: LayoutService, private router: Router) { }

    cadastro1() {
        this.router.navigate(['./empty/emptydemo.module']);
    }
}
