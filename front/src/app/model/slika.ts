import {Byte} from "@angular/compiler/src/util";

export class Slika {
  name: string;
  url : Byte[];
  size : number;


  constructor(name: string, url: Byte[], size: number) {
    this.name = name;
    this.url = url;
    this.size = size;
  }
}
