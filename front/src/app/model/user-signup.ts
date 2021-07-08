export class UserSignup {
  lozinka : string;
  username : string;
  ime : string;
  prezime : string;
  eMail : string;
  telefon : string;
  pol : string;
  datumRodj : Date;
  biografija : string;
  websajt : string;


  constructor(lozinka: string, username: string, ime: string, prezime: string, email: string, telefon: string, pol: string, datumRodj: Date, biografija: string, website: string) {
    this.lozinka = lozinka;
    this.username = username;
    this.ime = ime;
    this.prezime = prezime;
    this.eMail = email;
    this.telefon = telefon;
    this.pol = pol;
    this.datumRodj = datumRodj;
    this.biografija = biografija;
    this.websajt = website;
  }
}
