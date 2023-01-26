import { Component } from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent{
  result = 0;

  add(a: string, b: string){
      this.result = +a + +b;
  }
  sub(a: string, b: string){
      this.result = +a - +b;
  }
  mul(a: string, b: string){
      this.result = +a * +b;
  }
  div(a: string, b: string){
      this.result = +a / +b;
  }
}
