import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-register-products',
  templateUrl: './register-products.component.html',
  styleUrls: ['./register-products.component.scss']
})
export class RegisterProductsComponent implements OnInit {

  isAuthorization: boolean = true;

  constructor() { }

  ngOnInit(): void {
  }

}
