insert into USERS (rolee, id, username, lozinka) values ('registeredUser', nextval('seq_user'), 'd', '123');
insert into USERS (rolee, id, username, lozinka, ime, prezime, email, telefon, pol, datumrodj, biografija, websajt) values ('registeredUser', nextval('seq_user'), 'v', '123', 'Pera', 'Peric', 'pera@gmail.com', 0601112222, 'Musko', '1998-10-26', 'Programer XML', 'www.peraperic.com');
insert into USERS (rolee, id, username, lozinka) values ('admin', nextval('seq_user'), 'perica', '123');
insert into USERS (rolee, id, username, lozinka) values ('registeredUser', nextval('seq_user'), 'perica', '123');
insert into USERS (rolee, id, username, lozinka) values ('agent', nextval('seq_user'), 'perica1', '123');

insert into ZAHTEVZAVERIFIKACIJU (id,  status, obradjen, admin_id) values (nextval('seq_zahtevi_verifikacija'),  false, false,3);
insert into ZAHTEVZAVERIFIKACIJU (id,  status, obradjen, admin_id) values (nextval('seq_zahtevi_verifikacija'),  false, false,3);
insert into ZAHTEVZAVERIFIKACIJU (id,  status, obradjen, admin_id) values (nextval('seq_zahtevi_verifikacija'),  false, false,3);
