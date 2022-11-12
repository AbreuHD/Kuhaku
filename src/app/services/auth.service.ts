import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { KuhakuLogin } from '../interfaces/auth';
const { Observable } = require('rxjs')
const { filter } = require('rxjs/operators')
import { ElectronStoreService } from '../services/electron-store.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private kuhakuLogin = 'https://api.kuhaku.online/v1/Account/Login'; 

  constructor(private http: HttpClient, private storage: ElectronStoreService) { }

  loginKuhaku(user: string, password: string){
    let params = new HttpParams();
    params = params.set('userName', user);
    params = params.set('password', password);
    this.http.get<KuhakuLogin>(this.kuhakuLogin, {params}).subscribe((data) => {
      let response = data;
      if(response.hasError){
        return false;
      }
      this.storage.set('jwToken', response.jwToken);
      return true;
    });
  }

  loginStatus(){
    let jwToken = this.storage.get('jwToken');
    if(jwToken){
      return true;
    }
    return false;
  }

  logout(){
    this.storage.delete('jwToken');
    return true;
  }

}
