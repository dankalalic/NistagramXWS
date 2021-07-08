export class tekstualnaPorukaSadrzaj {
  idPosaljioca: number;
  idPrimaoca: number;
  tekstPoruke: string;


  constructor(idPosaljioca: number, idPrimaoca: number, tekstPoruke: string) {
    this.idPosaljioca = idPosaljioca;
    this.idPrimaoca = idPrimaoca;
    this.tekstPoruke = tekstPoruke;
  }
}
