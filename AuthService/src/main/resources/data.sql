insert into USERS (id, username, password, role, enabled) values (nextval('seq_user'), 'd',  '$2y$12$7gZv4xiHIOlkEQ8ByETU.uDVGsTVdYvkZfCDlDHSF.FoMu258kHKm', 'user', True);
insert into USERS (id, username, password, role, enabled) values (nextval('seq_user'), 'v',  '$2y$12$7gZv4xiHIOlkEQ8ByETU.uDVGsTVdYvkZfCDlDHSF.FoMu258kHKm', 'agent', True);

insert into AUTHORITY (name) values ('ROLE_USER');
insert into AUTHORITY (name) values ('ROLE_AGENT');
insert into AUTHORITY (name) values ('ROLE_ADMIN');

INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (1, 1);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (2, 2);