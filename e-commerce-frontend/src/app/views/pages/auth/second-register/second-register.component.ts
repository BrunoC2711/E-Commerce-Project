import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { UserModel } from 'src/app/views/models/form/user.model';

@Component({
  selector: 'app-second-register',
  templateUrl: './second-register.component.html',
  styleUrls: ['./second-register.component.scss']
})
export class SecondRegisterComponent implements OnInit {
  user : UserModel ={
    nome:  `${localStorage.getItem('nome')}`,
    endereco:  `${localStorage.getItem('endereco')}`,
    email:  `${localStorage.getItem('email')}`,
    login:  ``,
    senha:  ``
  }
  constructor(private router: Router) { }

  ngOnInit(): void {
    localStorage.clear()
  }
  saveData() {
    sessionStorage.setItem('nome', `${this.user.nome}` );
    sessionStorage.setItem('email', `${this.user.email}`);
    sessionStorage.setItem('login', `${this.user.login}`);
    sessionStorage.setItem('senha', `${this.user.senha}`);
    sessionStorage.setItem('endereco', `${this.user.endereco}`);
    //sessionStorage.setItem('foto', `${this.user.foto}` );
    console.log(this.user)
    this.router.navigate(['/'])
  }
  comeBack(): void{
    this.router.navigate(['../auth/register'])
  }
}
