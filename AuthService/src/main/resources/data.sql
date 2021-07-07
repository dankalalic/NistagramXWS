insert into USERS (id, username,age, password, role, enabled) values (nextval('seq_user'), 'd', 23, '$2y$12$7gZv4xiHIOlkEQ8ByETU.uDVGsTVdYvkZfCDlDHSF.FoMu258kHKm', 'user', True);
insert into USERS (id, username,age, password, role, enabled) values (nextval('seq_user'), 'v', 22, '$2y$12$7gZv4xiHIOlkEQ8ByETU.uDVGsTVdYvkZfCDlDHSF.FoMu258kHKm', 'user', True);

insert into AUTHORITY (name) values ('ROLE_USER');

INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (1, 1);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (2, 1);