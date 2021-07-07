import DateTimeFormat = Intl.DateTimeFormat;

export class JednokratnaKampanja {
  id : number | null
  pol: string
  godinePocetka : number
  godineKraja: number
  slike : Array<any>=[]
  //linkovi : Array<string>=[]
  pocetakPrikazivanja: DateTimeFormat
  krajPrikazivanja: DateTimeFormat


  constructor(id: number | null, pol: string, godinePocetka: number, godineKraja: number, slike: Array<any>, pocetakPrikazivanja: Intl.DateTimeFormat, krajPrikazivanja: Intl.DateTimeFormat) {
    this.id = id;
    this.pol = pol;
    this.godinePocetka = godinePocetka;
    this.godineKraja = godineKraja;
    this.slike = slike;
    this.pocetakPrikazivanja = pocetakPrikazivanja;
    this.krajPrikazivanja = krajPrikazivanja;
  }
}
