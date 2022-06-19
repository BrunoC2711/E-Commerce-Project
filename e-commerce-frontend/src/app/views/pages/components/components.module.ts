import { MaterialModule } from './../material/material.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ComponentsComponent } from './components.component';
import { HttpClientModule } from '@angular/common/http';
import { ProductsComponent } from './products/products.component';
import { PerfilProductComponent } from './perfil-product/perfil-product.component';
import { PagamentoComponent } from './pagamento/pagamento.component';
import { RegisterProductsComponent } from './register-products/register-products.component';


const routes: Routes = [
  {
    path: '',
    component: ComponentsComponent,
    children: [
      {
        path: '',
        redirectTo: 'login',
        pathMatch: 'full'
      },
      {
        path: 'products',
        component: ProductsComponent
      },
      {
        path: 'perfil-product',
        component: PerfilProductComponent
      },
      {
        path: 'pagamento',
        component: PagamentoComponent
      },
      {
        path: 'register-products',
        component: RegisterProductsComponent
      }
    ]
  },
]

@NgModule({
  declarations: [
    ComponentsComponent,
    ProductsComponent,
    PerfilProductComponent,
    PagamentoComponent,
    RegisterProductsComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    MaterialModule
  ]
})
export class ComponentsModule { }