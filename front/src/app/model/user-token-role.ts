export class UserTokenRole {

  accessToken : string;
  expiresIn : number;
  enabled: boolean;


  constructor(accessToken: string, expiresIn: number, enabled: boolean) {
    this.accessToken = accessToken;
    this.expiresIn = expiresIn;
    this.enabled = enabled;
  }
}
