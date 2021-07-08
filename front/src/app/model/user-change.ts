export class UserChange {
  taggable : boolean;
  acceptmsg : boolean;
  isp : boolean;
  allowNotifs : boolean;

  constructor(taggable: boolean, acceptmsg: boolean, isp: boolean, allownotifs: boolean) {
    this.taggable = taggable;
    this.acceptmsg = acceptmsg;
    this.isp = isp;
    this.allowNotifs = allownotifs;
  }
}
