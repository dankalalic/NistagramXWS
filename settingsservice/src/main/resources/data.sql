insert into USERS (rolee, id, username, lozinka) values ('registeredUser', nextval('seq_user'), 'pera', '123');
insert into USERS (rolee, id, username, lozinka) values ('registeredUser', nextval('seq_user'), 'perica', '123');
insert into USERS (rolee, id, username, lozinka) values ('admin', nextval('seq_user'), 'perica', '123');
insert into USERS (rolee, id, username, lozinka, ime, prezime, email, telefon, pol, datumrodj, biografija, websajt) values ('registeredUser', nextval('seq_user'), 'pera', '123', 'Pera', 'Peric', 'pera@gmail.com', 0601112222, 'Musko', '1998-10-26', 'Programer XML', 'www.peraperic.com');




insert into ZAHTEVZAVERIFIKACIJU (id, slika, status, admin_id) values (nextval('seq_user'), 'efefekefogeog', false,3);

