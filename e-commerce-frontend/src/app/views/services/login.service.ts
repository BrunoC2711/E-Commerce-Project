import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { LogonModel } from '../models/form/logon.Model';
import { ResponseUserLoginModel } from '../models/form/responseUserLogin.model';


@Injectable({
  providedIn: 'root'
})
export class LoginService {
  baseUrl = environment.baseUrlLogon
  constructor(private httpClient: HttpClient) { }
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  }
  public doLogon(requestLogin: LogonModel): Observable<ResponseUserLoginModel>{

    /*let formData: any = new FormData();
    formData.append("email",requestLogin.login);
    formData.append("senha",requestLogin.senha);*/
    return  this.httpClient.post<ResponseUserLoginModel>( this.baseUrl, JSON.stringify(requestLogin),this.httpOptions);
  }
  public doLogout(){
    return this.httpClient.post(this.baseUrl, this.httpOptions)
  }
}