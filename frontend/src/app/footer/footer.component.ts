import { Component, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {
  @Output() header1: string = "Get a Job";
  constructor() { }

  ngOnInit(): void {
  }

}
