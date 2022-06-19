import { ProductModel } from './../../../models/form/product.model';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductsService } from 'src/app/views/services/products.service';
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss']
})
export class ProductsComponent implements OnInit {
  readonly semFoto = "https://th.bing.com/th/id/R2fa0e781e0ce67556696ff4c6c4b63e5?rik=hBRNVFxNOktXBQ&riu=http%3a%2f%2fwww.casadei.com%2fon%2fdemandware.static%2fSites-casadei-Site%2f-%2fdefault%2fdw4b2b381d%2fimages%2fnoimagezoom.png&ehk=wcv6SXPeSxuaULGIjt2rwDmNSUkUQD3%2fa2ISxDTgOkI%3d&risl=&pid=ImgRaw"

  products: ProductModel[] = [];

  constructor(private router: Router ,private productService: ProductsService, private fb: FormBuilder) {

  }

  ngOnInit() {
    this.productService.read().subscribe(products => {
      this.products = products;
    })
  }
  produtoEscolhido(product: ProductModel):void{
    localStorage.setItem("product.descricao", `${product.descricao}`)
    localStorage.setItem("product.fotos", `${product.fotos}`)
    localStorage.setItem("product.preco", `${product.preco}`)
    localStorage.setItem("product.quantidade", `${product.quantidade}`)
    localStorage.setItem("product.titulo", `${product.titulo}`)
    this.router.navigate(['../components/perfil-product'])
  }
}
