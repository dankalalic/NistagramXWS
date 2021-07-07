insert into PRODAVNICA(id) values (nextval('seq_prodavnica'));
insert into users(id, rolee,prodavnica_id) values (2, 'agent',1);
insert into users(id,rolee) values (1,'user');


--insert into proizvod(id, cena, raspolozivo_stanje, naziv) values (nextval('seq_proizvod'), 100, 100, 'nesto');