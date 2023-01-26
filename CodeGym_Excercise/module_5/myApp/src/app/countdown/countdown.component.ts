import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-countdown',
  templateUrl: './countdown.component.html',
  styleUrls: ['./countdown.component.css']
})
export class CountdownComponent implements OnInit{
  @Input() countdown: number | string | undefined;
  interval: any
  a: number | string | undefined
  start(){
    this.interval = setInterval(() => {
      // @ts-ignore
      this.a = +this.a - 1;
      if (this.a == 0) {
        clearInterval(this.interval);
      }
    }, 1000);
  }
  stop(){
    clearInterval(this.interval)
  }
  reset(){
    clearInterval(this.interval)
    this.a = this.countdown
  }

  ngOnInit(): void {
    this.a = this.countdown
  }
}
