export class RegisteredUser {
  id: number;
  lozinka: string;
  username: string;


  constructor(id: number, lozinka: string, username: string) {
    this.id = id;
    this.lozinka = lozinka;
    this.username = username;
  }
}
