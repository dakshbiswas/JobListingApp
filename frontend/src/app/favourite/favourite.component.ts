import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';

const headers = new HttpHeaders()
  .set('Access-Control-Allow-Origin', '*')


@Component({
  selector: 'app-favourite',
  templateUrl: './favourite.component.html',
  styleUrls: ['./favourite.component.css']
})
export class FavouriteComponent implements OnInit {
  @Input() job: any;
  @Input() index: number;
  userId = localStorage.getItem('userId');
  jobs: any;
  searchResults: any[] = [];
  url = "localhost:8080/favorites/api/v1/";
  museApi = "https://www.themuse.com/api/public/jobs/";
  constructor(private http: HttpClient) {
    this.showFavorite();
  }

  ngOnInit(): void {
  }

  showFavorite(): void {
    this.http.get(`http://localhost:8081/favorites/api/v1/users/${this.userId}`)
      .subscribe((data) => {
        for (let key in data) {
          this.searchFavorite(data[key])
        }
      });
  }

  searchFavorite(jobId: string){
    this.http.get(this.museApi+jobId)
    .subscribe((data) => {
      this.searchResults.push(data);
      // console.log("searchFavourite(): ", data);
      console.log("checkSearchResult: ", this.searchResults);
    });
  }

  backdropStyle = () => {
    return {
      background: `linear-gradient(180deg, rgba(0,0,0,.7), transparent), url(https://i.stack.imgur.com/XriZj.png)`,
      "background-size": "cover"
    };
  };

  animationDelay = () => ({
    "animation-delay": `${this.index * 0.15}s`
  });

  deleteFavorite(id: string): boolean {
    this.http.post("http://localhost:8081/favorites/api/v1/jobs/delete",
      {
        "jobid": id,
        "userid": this.userId
      })
      .subscribe((data) => console.log("deleted: ", data))
      window.location.href="/favourites";
    return true;
  }
}