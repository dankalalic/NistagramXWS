export class Proizvod {
  cena : number;
  raspolozivoStanje : number;
  slika:number;
  naziv:string;


  constructor(cena: number, raspolozivoStanje: number, slika: number, naziv: string) {
    this.cena = cena;
    this.raspolozivoStanje = raspolozivoStanje;
    this.slika = slika;
    this.naziv = naziv;
  }
}
