insert into KOMENTAR(id, text) values (nextval('seq_komentar'), 'Apoteka Jankovic');
insert into KOMENTAR(id, text) values (nextval('seq_komentar'), 'nesto lepo treba da se desi');
insert into KOMENTAR(id, text) values (nextval('seq_komentar'), 'radi daki');

insert into TAGOVI(id, naziv) values (nextval('seq_tagovi'), 'macka');
insert into TAGOVI(id, naziv) values (nextval('seq_tagovi'), 'ker');

insert into LOKACIJA(id, naziv) values (nextval('seq_post'), 'Novi Sad');
insert into LOKACIJA(id, naziv) values (nextval('seq_post'), 'Zrenjanin');

insert into REGISTROVANIKORISNIK (id) values (1);
insert into REGISTROVANIKORISNIK (id) values (2);
insert into REGISTROVANIKORISNIK (id) values (3);

insert into SADRZAJ(id, tip, lokacija_id, kreator_id, brojreportova) values (nextval('seq_sadrzaj'), 'post', 1, 1, 0);
insert into SADRZAJ(id, tip, lokacija_id, kreator_id, brojreportova) values (nextval('seq_sadrzaj'), 'post', 1, 1, 1);
insert into SADRZAJ(id, tip, lokacija_id, kreator_id, brojreportova) values (nextval('seq_sadrzaj'), 'post', 1, 1, 0);
insert into SADRZAJ(id, tip, lokacija_id, kreator_id, brojreportova) values (nextval('seq_sadrzaj'), 'post', 2, 1, 0);

insert into SLIKA (id, url, sadrzaj_id) values (nextval('seq_slika'), 'https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/dog-puppy-on-garden-royalty-free-image-1586966191.jpg?crop=1.00xw:0.669xh;0,0.190xh&resize=1200:*', 1);
insert into SLIKA (id, url, sadrzaj_id) values (nextval('seq_slika'), 'macki.jpg', 1);

--insert into TAGOVANI(tagovi_id, sadrzaj_id) values (1, 1);
--insert into TAGOVANI(tagovi_id, sadrzaj_id) values (1, 1);

insert into LAJKOVALI(sadrzajlajkovani_id, registrovanikorisniklajkovan_id) values(1, 1);
insert into LAJKOVALI(sadrzajlajkovani_id, registrovanikorisniklajkovan_id) values(1, 2);

insert into DISLAJKOVALI(dislajkovan_id, registrovanikorisnik_id) values(2, 1);
insert into DISLAJKOVALI(dislajkovan_id, registrovanikorisnik_id) values(2, 2);
