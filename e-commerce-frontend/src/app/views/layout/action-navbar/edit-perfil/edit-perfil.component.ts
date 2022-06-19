import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { UserModel } from 'src/app/views/models/form/user.model';

@Component({
  selector: 'app-edit-perfil',
  templateUrl: './edit-perfil.component.html',
  styleUrls: ['./edit-perfil.component.scss']
})
export class EditPerfilComponent implements OnInit {
  user : UserModel ={
    nome:  `${sessionStorage.getItem('nome')}`,
    endereco:  `${sessionStorage.getItem('endereco')}`,
    email:  `${sessionStorage.getItem('email')}`,
    login:  `${sessionStorage.getItem('login')}`,
    senha:  `${sessionStorage.getItem('senha')}`,
    foto:  `../../../../assets/images/${sessionStorage.getItem('foto')}`
  }
  constructor() { }

  ngOnInit(): void {
  }
  saveData() {
    sessionStorage.setItem('nome', `${this.user.nome}` );
    sessionStorage.setItem('email', `${this.user.email}`);
    sessionStorage.setItem('login', `${this.user.login}`);
    sessionStorage.setItem('senha', `${this.user.senha}`);
    sessionStorage.setItem('endereco', `${this.user.endereco}`);
    location.reload()
    
  }
}
