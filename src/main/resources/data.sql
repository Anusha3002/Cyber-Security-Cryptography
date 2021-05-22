INSERT INTO privilege (id,name) SELECT 100,'READ_PRIVILEGE'
WHERE NOT EXISTS (SELECT * FROM privilege WHERE name='READ_PRIVILEGE');
INSERT INTO privilege (id,name) SELECT 101,'WRITE_PRIVILEGE'
WHERE NOT EXISTS (SELECT * FROM privilege WHERE name='WRITE_PRIVILEGE');

INSERT INTO role (id,name) SELECT 200, 'READ_PRIVILEGE'
WHERE NOT EXISTS (SELECT * FROM role WHERE name='READ_PRIVILEGE');
INSERT INTO role (id,name) SELECT 201, 'WRITE_PRIVILEGE'
WHERE NOT EXISTS (SELECT * FROM role WHERE name='WRITE_PRIVILEGE');

INSERT INTO roles_privileges (role_id, privilege_id) SELECT 200, 100
WHERE NOT EXISTS (SELECT * FROM roles_privileges WHERE role_id=200);
INSERT INTO roles_privileges (role_id, privilege_id) SELECT 201, 101
WHERE NOT EXISTS (SELECT * FROM roles_privileges WHERE role_id= 201);

INSERT INTO user_account (id,first_name,last_name,email, password, enabled,IS_USING2FA)
SELECT 1, 'Anusha', 'Choudhary', 'anushamnnit@gmail.com', '$2a$11$s.KwcqXWCc/q3QA1k4Ft2eUkkN/yeZXKyUZx6KEjEtp24KeSJ3a4y', TRUE, FALSE
WHERE NOT EXISTS (SELECT * FROM user_account WHERE email='vipin@pabay.in');

INSERT INTO users_roles (user_id,role_id ) SELECT 1, 200
WHERE NOT EXISTS (SELECT * FROM users_roles WHERE role_id= 200);
INSERT INTO users_roles (user_id,role_id ) SELECT 1, 201
WHERE NOT EXISTS (SELECT * FROM users_roles WHERE role_id= 201);