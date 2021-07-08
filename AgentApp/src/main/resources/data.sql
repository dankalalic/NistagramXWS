insert into PRODAVNICA(id) values (nextval('seq_prodavnica'));
insert into users(id, rolee,prodavnica_id) values (2, 'agent',1);
insert into users(id,rolee) values (1,'user');

--insert into proizvod(id, cena, RASPOLOZIVOSTANJE, naziv, AGENT_ID, prodavnica_id) values (nextval('seq_proizvod'), 100, 100, 'nesto', 2, 1);