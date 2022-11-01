import { Injectable } from '@angular/core';
import * as ElectronStore from 'electron-store';

@Injectable({
  providedIn: 'root'
})
export class ElectronStoreService {
  private store!: ElectronStore;
  constructor() {
    if (window.require) {
      try {
        const storeClass = window.require("electron-store");
        this.store = new storeClass();
      } catch (e) {
        throw e;
      }
    } else {
      console.warn("electron-store was not loaded");
    }
   }

   //This function returns the value of the key stored locally with electron-store.
   get = (key: string): any => {
    return this.store.get(key);
   }

   /* And this other function sets the value of the key we want to store.
      (If the key already exists, the value will be replaced) */
   set = (key: string, value: any): void => {
     this.store.set(key, value);
   }

   delete = (key: string): any => {
    return this.store.delete(key);
   }
}
