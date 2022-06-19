import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { LogonModel } from 'src/app/views/models/form/logon.Model';
import { ResponseUserLoginModel } from 'src/app/views/models/form/responseUserLogin.model';
import { LoginService } from 'src/app/views/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  public requestLogin: LogonModel= new LogonModel();
  public responseLogin: ResponseUserLoginModel = new ResponseUserLoginModel();
  isAuthenticated: boolean = false;
  returnUrl: any; 
  user_id : string;

  constructor(private router: Router, private route: ActivatedRoute, private loginService : LoginService) { }

  ngOnInit(): void {
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
    this.requestLogin = new LogonModel();
    this.responseLogin = new ResponseUserLoginModel();
    localStorage.clear();
  }

  public saveParams(usercredenciais:ResponseUserLoginModel): void {    
    console.log(usercredenciais)
    this.user_id = JSON.stringify(usercredenciais.id);    
    this.responseLogin = usercredenciais;

    if(!usercredenciais.status)
    {
      this.router.navigate(['/auth/login']);
    }
    else
    {
    localStorage.setItem('LoggedUserId',this.user_id);
    localStorage.setItem('UserToken', usercredenciais.token);
    localStorage.setItem('isLoggedin', '1');   
    this.router.navigate([this.returnUrl]);
    }
    /*
    get stored object 
    let storedSettings = JSON.parse(localStorage.getItem('LoggedUserId') || '{}');
    console.log(storedSettings);
    */
  }
  login(): void {
    this.router.navigate(['/'])
  }
  onLoggedin()  {     
    this.loginService.doLogon(this.requestLogin).subscribe({
      next: (v) => this.responseLogin = v,       
      error:(e) => console.error(e),
      complete: () => this.saveParams(this.responseLogin)
    })  
  }
}
  
