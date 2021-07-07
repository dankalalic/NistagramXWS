export class Visekratna {
  id : number | null
  pol: string
  godinePocetka : number
  godineKraja: number
  slike : Array<any>=[]
  //linkovi : Array<string>=[]
  pocetakPrikazivanja: Date
  krajPrikazivanja: Date
  potrebanBrojPrikazivanja:number


  constructor(id: number | null, pol: string, godinePocetka: number, godineKraja: number, slike: Array<any>, pocetakPrikazivanja: Date, krajPrikazivanja: Date, potrebanBrojPrikazivanja: number) {
    this.id = id;
    this.pol = pol;
    this.godinePocetka = godinePocetka;
    this.godineKraja = godineKraja;
    this.slike = slike;
    this.pocetakPrikazivanja = pocetakPrikazivanja;
    this.krajPrikazivanja = krajPrikazivanja;
    this.potrebanBrojPrikazivanja = potrebanBrojPrikazivanja;
  }
}
