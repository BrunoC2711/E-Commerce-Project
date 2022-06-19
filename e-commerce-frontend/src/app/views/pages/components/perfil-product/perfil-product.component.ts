import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { ProductModel } from 'src/app/views/models/form/product.model';
import { ProductsService } from 'src/app/views/services/products.service';

@Component({
  selector: 'app-perfil-product',
  templateUrl: './perfil-product.component.html',
  styleUrls: ['./perfil-product.component.scss']
})
export class PerfilProductComponent implements OnInit {

  itensCart = ['']; 
  product_titulo = localStorage.getItem("product.titulo")
  product_descricao = localStorage.getItem("product.descricao")
  product_fotos = localStorage.getItem("product.fotos")
  product_preco = localStorage.getItem("product.preco")
  product_quantidade = localStorage.getItem("product.quantidade")

  product: ProductModel;

  constructor(private router: Router ,private productService: ProductsService) {
  }

  ngOnInit() {
    this.productService.readByTitle(`${this.product_titulo}`).subscribe(product => {
      this.product = product;
    })
  }
  addItemInCart(): void {
    this.itensCart.push(`${this.product.id}`)
    console.log(this.itensCart)
  }
  purchase(): void {
    this.router.navigate(['../components/pagamento'])
  }
}
