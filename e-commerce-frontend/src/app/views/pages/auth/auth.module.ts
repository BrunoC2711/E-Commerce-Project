import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login/login.component';
import { Routes, RouterModule } from '@angular/router';
import { AuthComponent } from './auth.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RegisterComponent } from './register/register.component';
import { SecondRegisterComponent } from './second-register/second-register.component';

const routes: Routes = [
  {
    path: '',
    component: AuthComponent,
    children: [
      {
        path: '',
        redirectTo: 'login',
        pathMatch: 'full'
      },
      {
        path: 'login',
        component: LoginComponent
      },
      {
        path: 'register',
        component: RegisterComponent
      },
      {
        path: 'second-register',
        component: SecondRegisterComponent
      }
    ]
  },
]

@NgModule({
  declarations: [LoginComponent,RegisterComponent, AuthComponent, SecondRegisterComponent],
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    FormsModule,   
    HttpClientModule

  ]
})
export class AuthModule { }
