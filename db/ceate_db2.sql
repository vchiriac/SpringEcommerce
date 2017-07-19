INSERT INTO permissions (id, name) VALUES
(1, 'MANAGE_CATEGORIES'),
(2, 'MANAGE_PRODUCTS'),
(3, 'MANAGE_ORDERS'),
(4, 'MANAGE_CUSTOMERS'),
(5, 'MANAGE_PAYMENT_SYSTEMS'),
(6, 'MANAGE_USERS'),
(7, 'MANAGE_ROLES'),
(8, 'MANAGE_PERMISSIONS'),
(9, 'MANAGE_SETTINGS');


INSERT INTO profiles (id, type) VALUES
(1, 'ADMIN'),
(2, 'CMS_ADMIN'),
(3, 'USER'),
(4, 'DBA')
;

INSERT INTO users (id, email, password, SSO_ID) VALUES
(1, 'admin@gmail.com', '$2a$10$dn6n7NgUoFXUz7wdAoEPQuCnstk5Zvf1ygrEPipMYuRylUWOb0jvu', 'Admin'),
(2, 'cms@gmail.com', '$2a$10$dn6n7NgUoFXUz7wdAoEPQuCnstk5Zvf1ygrEPipMYuRylUWOb0jvu', 'CMSGuy'),
(3, 'valentinchiriac@gmail.com', '$2a$10$dn6n7NgUoFXUz7wdAoEPQuCnstk5Zvf1ygrEPipMYuRylUWOb0jvu', 'vali'),
(4, 'dba@gmail.com', '$2a$10$dn6n7NgUoFXUz7wdAoEPQuCnstk5Zvf1ygrEPipMYuRylUWOb0jvu', 'DBAUser');


insert into profile_permission(profile_id, perm_id) values
(1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),
(2,1),(2,2),(2,3),(2,4),(2,5),(2,9),
(3,6),(3,7),(3,8),(3,9)
;

insert into user_profile(user_id, profile_id) values
(1,1),
(2,2),
(3,3),
(4,4);