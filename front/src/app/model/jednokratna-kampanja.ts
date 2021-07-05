export class JednokratnaKampanja {
  pol: string
  godinePocetka : number
  godineKraja: number
  slike : Array<any>=[]
  linkovi : Array<string>=[]
  datumPrikazivanja: Date

  constructor(pol: string, godinePocetka: number, godineKraja: number, slike: Array<any>, linkovi: Array<string>, datumPrikazivanja: Date) {
    this.pol = pol;
    this.godinePocetka = godinePocetka;
    this.godineKraja = godineKraja;
    this.slike = slike;
    this.linkovi = linkovi;
    this.datumPrikazivanja = datumPrikazivanja;
  }
}
