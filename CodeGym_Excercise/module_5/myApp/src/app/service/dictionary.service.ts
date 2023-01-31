import { Injectable } from '@angular/core';
import {IWord} from "../model/iword";

@Injectable({
  providedIn: 'root'
})
export class DictionaryService {
dictionaries: IWord[] = [
  {
    word: 'Wallet',
    mean: 'Vi tien'
  },
  {
    word: 'pear',
    mean: 'Qua Le'
  },
  {
    word: 'Regretful',
    mean: 'Cam thay hoi tiec'
  },
  {
    word: 'Primitive',
    mean: 'Nguyen thuy'
  },
  {
    word: 'Valid',
    mean: 'Hop le'
  },
  {
    word: 'inductor',
    mean: 'Nguoi lam le nham chuc'
  },
]
  constructor() { }
  getAll(){
  return this.dictionaries
  }
}
