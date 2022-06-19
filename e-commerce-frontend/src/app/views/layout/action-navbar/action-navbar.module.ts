import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CarrinhoComponent } from './carrinho/carrinho.component';
import { ActionNavbarComponent } from './action-navbar.component';
import { EditPerfilComponent } from './edit-perfil/edit-perfil.component';
import { RequestsComponent } from './requests/requests.component';
import { MaterialModule } from '../../pages/material/material.module';

const routes: Routes = [
  {
    path: '',
    component: ActionNavbarComponent,
    children: [
      {
        path: '',
        redirectTo: 'login',
        pathMatch: 'full'
      },
      {
        path: 'carrinho',
        component: CarrinhoComponent
      },
      {
        path: 'edit-perfil',
        component: EditPerfilComponent
      },
      {
        path: 'requests',
        component: RequestsComponent
      }
    ]
  },
]

@NgModule({
  declarations: [
    ActionNavbarComponent,
    CarrinhoComponent,
    EditPerfilComponent,
    RequestsComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    FormsModule,
    HttpClientModule,
    MaterialModule
  ]
})
export class ActionNavbarModule { }
