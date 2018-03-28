-- ロール
INSERT INTO t_role (role_id, role_name, description) VALUES (1, 'ROLE_ADMIN', '管理ロール');
INSERT INTO t_role (role_id, role_name, description) VALUES (2, 'ROLE_USER', '一般ロール');

-- ユーザー
INSERT INTO t_user (username, password, full_name) VALUES ('admin', 'pass', '管理者太郎');
INSERT INTO t_user (username, password, full_name) VALUES ('user', 'pass', '一般次郎');

-- ユーザーロール
INSERT INTO t_user_role (role_id, user_id) VALUES (1, 1);
INSERT INTO t_user_role (role_id, user_id) VALUES (2, 2);
