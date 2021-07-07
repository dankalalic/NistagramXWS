import {JednokratnaKampanja} from "./jednokratna-kampanja";

export class JednokratnaToSend {
  jednokratna : Boolean;
  kampanja : JednokratnaKampanja


  constructor(jednokratna: Boolean, kampanja: JednokratnaKampanja) {
    this.jednokratna = jednokratna;
    this.kampanja = kampanja;
  }
}
