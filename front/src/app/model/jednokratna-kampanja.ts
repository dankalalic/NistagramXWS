import DateTimeFormat = Intl.DateTimeFormat;

export class JednokratnaKampanja {
  pol: string
  godinePocetka : number
  godineKraja: number
  slike : Array<any>=[]
  //linkovi : Array<string>=[]
  pocetakPrikazivanja: DateTimeFormat
  krajPrikazivanja: DateTimeFormat


  constructor(pol: string, godinePocetka: number, godineKraja: number, slike: Array<any>, pocetakPrikazivanja: DateTimeFormat, krajPrikazivanja: DateTimeFormat) {
    this.pol = pol;
    this.godinePocetka = godinePocetka;
    this.godineKraja = godineKraja;
    this.slike = slike;
    this.pocetakPrikazivanja = pocetakPrikazivanja;
    this.krajPrikazivanja = krajPrikazivanja;
  }
}
