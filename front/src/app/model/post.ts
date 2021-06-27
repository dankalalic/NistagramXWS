export class Post {
  userId:number;
  lokacija : string;
  tag : string;
  slike:Array<number>=[];


  constructor(userId: number, lokacija: string, tag: string, slike: Array<number>) {
    this.userId = userId;
    this.lokacija = lokacija;
    this.tag = tag;
    this.slike = slike;
  }
}
