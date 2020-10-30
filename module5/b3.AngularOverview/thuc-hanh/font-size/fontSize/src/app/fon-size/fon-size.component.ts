// @ts-ignore
import { Component, OnInit } from '@angular/core';

// @ts-ignore
@Component({
  selector: 'app-fon-size',
  templateUrl: './fon-size.component.html',
  styleUrls: ['./fon-size.component.css']
})
export class FonSizeComponent implements OnInit {

  fontSize = 14;
  constructor() { }
  onChange(value) {
    this.fontSize = value;
  }

  ngOnInit(): void {
  }

}
