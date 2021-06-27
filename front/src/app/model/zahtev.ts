export class Zahtev {
  ime:string;
  prezime : string;
  kategorija : string;
  slika:number;


  constructor(ime: string, prezime: string, kategorija: string, slika: number) {
    this.ime = ime;
    this.prezime = prezime;
    this.kategorija = kategorija;
    this.slika = slika;
  }
}
