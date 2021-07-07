insert into USERS (rolee, id, username, lozinka, enabled) values ('registeredUser', nextval('seq_user'), 'd', '123', true);
insert into USERS (rolee, id, username, lozinka, ime, prezime, email, telefon, pol, datumrodj, biografija, websajt, enabled) values ('registeredUser', nextval('seq_user'), 'v', '123', 'Pera', 'Peric', 'pera@gmail.com', 0601112222, 'Musko', '1998-10-26', 'Programer XML', 'www.peraperic.com', true);
insert into USERS (rolee, id, username, lozinka, enabled) values ('admin', nextval('seq_user'), 'perica', '123', true);
insert into USERS (rolee, id, username, lozinka, enabled) values ('registeredUser', nextval('seq_user'), 'perica', '123', true);

insert into ZAHTEVZAVERIFIKACIJU (id,  status, obradjen, admin_id) values (nextval('seq_zahtevi_verifikacija'),  false, false,3);
insert into ZAHTEVZAVERIFIKACIJU (id,  status, obradjen, admin_id) values (nextval('seq_zahtevi_verifikacija'),  false, false,3);
insert into ZAHTEVZAVERIFIKACIJU (id,  status, obradjen, admin_id) values (nextval('seq_zahtevi_verifikacija'),  false, false,3);

insert into ZAHTEVZAREGISTRACIJU(id, registeredUser_id, admin_id, odobren) values (nextval('seq_zahtevi_registracija'), 1, 3, false);