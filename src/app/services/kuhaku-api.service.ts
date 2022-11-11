import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Home, MovieDetails } from '../interfaces/kuhaku-api';
import { BTokenService } from '../services/b-token.service';
const { Observable } = require('rxjs')
const { filter } = require('rxjs/operators')

@Injectable({
  providedIn: 'root'
})
export class KuhakuAPIService {
  private kuhakuAPI = 'https://api.kuhaku.online/v1/es';
  constructor(private http: HttpClient, private token: BTokenService) { }

  getHome(skip: string){
    let params = new HttpParams();
    params = params.set('skip', skip);
    this.http.get<Home[]>(`${this.kuhakuAPI}/MovieList/GetMovieList`, {
      params,
      headers: {
        Authorization: `Bearer ${this.token.getJWTToken()}`,
      }
    }).subscribe((data) => {
      return data;
    });
  }

  getMovieDetails(tMBDId: string){
    let params = new HttpParams();
    params = params.set('tMBDId', tMBDId);
    this.http.get<MovieDetails>(`${this.kuhakuAPI}/Movie`, {
      params,
      headers: {
        Authorization: `Bearer ${this.token.getJWTToken()}`,
      }
    }).subscribe((data) => {
      return data;
    });
  }
}
