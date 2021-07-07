export class Visekratna {

  pol: string
  godinePocetka : number
  godineKraja: number
  slike : Array<any>=[]
  //linkovi : Array<string>=[]
  pocetakPrikazivanja: Date
  krajPrikazivanja: Date
  potrebanBrojPrikazivanja:number


  constructor(pol: string, godinePocetka: number, godineKraja: number, slike: Array<any>, pocetakPrikazivanja: Date, krajPrikazivanja: Date, potrebanBrojPrikazivanja: number) {
    this.pol = pol;
    this.godinePocetka = godinePocetka;
    this.godineKraja = godineKraja;
    this.slike = slike;
    //this.linkovi = linkovi;
    this.pocetakPrikazivanja = pocetakPrikazivanja;
    this.krajPrikazivanja = krajPrikazivanja;
    this.potrebanBrojPrikazivanja = potrebanBrojPrikazivanja;
  }
}
