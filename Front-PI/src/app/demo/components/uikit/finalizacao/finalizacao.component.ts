import { Component } from '@angular/core';

@Component({
    templateUrl: './finalizacao.component.html'
})
export class FinalizacaoComponent {
    constructor() {}

        ngOnInit(): void {}

        display: any;
        center: google.maps.LatLngLiteral = {
            lat: -16.6969001,
            lng: -49.2701967
        };
        zoom = 12;

        /*------------------------------------------
        --------------------------------------------
        moveMap()
        --------------------------------------------
        --------------------------------------------*/
        moveMap(event: google.maps.MapMouseEvent) {
            if (event.latLng != null) this.center = (event.latLng.toJSON());
        }

        /*------------------------------------------
        --------------------------------------------
        move()
        --------------------------------------------
        --------------------------------------------*/
        move(event: google.maps.MapMouseEvent) {
            if (event.latLng != null) this.display = event.latLng.toJSON();

            }
    }
