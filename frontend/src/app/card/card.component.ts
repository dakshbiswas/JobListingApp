import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent{
  @Input() job: any;
  @Input() index: number;

  backdropStyle = () => {
    //console.log("Job: ", this.job);
    return {
      background: `linear-gradient(180deg, rgba(0,0,0,.7), transparent), url(https://i.stack.imgur.com/XriZj.png)`,
      "background-size": "cover"
    };
  };

  animationDelay = () => ({
    "animation-delay": `${this.index * 0.15}s`
  });
}
