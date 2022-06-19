import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserModel } from 'src/app/views/models/form/user.model';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {
  user : UserModel ={
    nome: '',
    endereco: '',
    email: ''
  }
  constructor(private router: Router) { }
  nextAndSaveDatas(): void{
    localStorage.setItem('nome', `${this.user.nome}`);
    localStorage.setItem('email', `${this.user.email}`);
    localStorage.setItem('endereco', `${this.user.endereco}`);
    console.log(this.user)
    this.router.navigate(['../auth/second-register'])
  }
}
