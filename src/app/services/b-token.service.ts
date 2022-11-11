import { Injectable } from '@angular/core';
import { ElectronStoreService } from '../services/electron-store.service';

@Injectable({
  providedIn: 'root'
})
export class BTokenService {

  constructor(private jwt: ElectronStoreService) { }

  getJWTToken(){
    return this.jwt.get('jwToken');
  }
}
