import {Component} from '@angular/core';
import {ActivatedRoute, ParamMap} from "@angular/router";
import {DictionaryService} from "../service/dictionary.service";

@Component({
  selector: 'app-dictionary-detail',
  templateUrl: './dictionary-detail.component.html',
  styleUrls: ['./dictionary-detail.component.css']
})
export class DictionaryDetailComponent {
  word: any
  mean: any

  constructor(private dictionaryService: DictionaryService, private activatedRoute: ActivatedRoute) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.word = paramMap.get('word')
      const wordDetail = this.getWord(this.word)
      // @ts-ignore
      this.mean = wordDetail.mean
    })
  }

  // @ts-ignore
  getWord(word: string) {
    // @ts-ignore
    for (let i = 0; i < this.dictionaryService.getAll().length; i++) {
      if (this.dictionaryService.getAll()[i].word === word) {
        return this.dictionaryService.getAll()[i]
      }
    }
  }
}
