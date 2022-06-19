import { Component, OnInit, ViewChild, ElementRef, Inject, Renderer2 } from '@angular/core';
import { DOCUMENT } from '@angular/common';
import { Router } from '@angular/router';
import { UserModel } from '../../models/form/user.model';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {
  user_logado : boolean = true;
  user: UserModel = {
    nome: "Monkey D. Luffy",
    email: "zoan_nikka@gmail.com",
    foto: "../../../../assets/images/luffy.jpg"   
  }

  constructor(
    @Inject(DOCUMENT) private document: Document, 
    private renderer: Renderer2,
    private router: Router
  ) { }

  ngOnInit(): void {
    if (localStorage.getItem('isLoggedin')) {
      this.user_logado = true;
    }
    if(this.user_logado && sessionStorage.getItem('nome') != null && sessionStorage.getItem('email')!= null){
      this.user.nome = `${sessionStorage.getItem('nome')}`;
      this.user.email = `${sessionStorage.getItem('email')}`;
      //this.user.foto = `../../../../assets/images/${sessionStorage.getItem('foto')}`;
      this.user.foto = `../../../../assets/images/${this.user.foto}`;
    }
  }

  /**
   * Sidebar toggle on hamburger button click
   */
  toggleSidebar(e: Event) {
    e.preventDefault();
    this.document.body.classList.toggle('sidebar-open');
  }

  /**
   * Logout
   */
  onLogout(e: Event) {
    e.preventDefault();
    sessionStorage.clear()
    localStorage.removeItem('isLoggedin');
    localStorage.removeItem('LoggedUserId');
    localStorage.removeItem('UserToken');

    if (!localStorage.getItem('isLoggedin')) {
      this.router.navigate(['/auth/login']);
    }
  }

}
