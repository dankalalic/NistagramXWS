
insert into USERS (id, username, password, role, enabled) values (1, 'd',  '$2y$12$7gZv4xiHIOlkEQ8ByETU.uDVGsTVdYvkZfCDlDHSF.FoMu258kHKm', 'user', True);
insert into USERS (id, username, password, role, enabled) values (2, 'v',  '$2y$12$7gZv4xiHIOlkEQ8ByETU.uDVGsTVdYvkZfCDlDHSF.FoMu258kHKm', 'agent', True);
insert into USERS (id, username, password, role, enabled) values (3, 'admin',  '$2y$12$7gZv4xiHIOlkEQ8ByETU.uDVGsTVdYvkZfCDlDHSF.FoMu258kHKm', 'admin', True);


insert into AUTHORITY (name) values ('ROLE_USER');
insert into AUTHORITY (name) values ('ROLE_ADMIN');

INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (1, 1);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (2, 1);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (3, 2);
