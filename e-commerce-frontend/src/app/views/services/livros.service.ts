import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { LivroModel } from '../models/form/livros.model';



@Injectable({
  providedIn: 'root'
})
export class LivrosService {
  
  baseUrl = environment.baseUrl + 'livro';
  //  baseUrl = 'http://162.214.68.181:83/api/livro';
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json'  })
  }
  constructor(private http: HttpClient) { }
  
  salvar(livro: LivroModel): Observable<LivroModel> {
    return this.http.post<LivroModel>(this.baseUrl, livro);
  }

  create(livro:LivroModel): Observable<LivroModel>{
    const url = `${this.baseUrl}/AddLivros`
    //return this.http.post<LivroModel>(url,Livro)
    return this.http.post<LivroModel>(url,JSON.stringify(livro),this.httpOptions)
  }
  read(): Observable<LivroModel[]>{
    const url = `${this.baseUrl}`
    return this.http.get<LivroModel[]>(url)
  }
  readById(id: number): Observable<LivroModel>{
    const url = `${this.baseUrl}/GetLivroId?id=${id}` 
    return this.http.get<LivroModel>(url);
  }
  readByUf(uf: number): Observable<LivroModel>{
    const url = `${this.baseUrl}/GetLivroUf?uf=${uf}` 
    return this.http.get<LivroModel>(url);
  }
  update(livro: LivroModel): Observable<LivroModel> {
    const url = `${this.baseUrl}/EditarLivros`
    return this.http.post<LivroModel>(url,JSON.stringify(livro),this.httpOptions)
    //return this.http.put<LivroModel>(url, Livro)
  }
  delete(Livro: LivroModel): Observable<LivroModel>{
    const url = `${this.baseUrl}/DeleteLivro?id=${Livro.id}`;
    return this.http.post<LivroModel>(url,Livro);
  }
}