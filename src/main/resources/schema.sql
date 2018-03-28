-- ロール
CREATE TABLE t_role (
  role_id BIGINT,
  role_name VARCHAR (100),
  description VARCHAR (100),
  PRIMARY KEY(role_id)
);

-- ユーザー
CREATE TABLE t_user (
  user_id SERIAL,
  username VARCHAR(100),
  password VARCHAR(100),
  full_name VARCHAR(100),
  PRIMARY KEY(user_id)
);

-- ユーザーロール
CREATE TABLE t_user_role (
  role_id BIGINT REFERENCES t_role(role_id),
  user_id BIGINT REFERENCES t_user(user_id)
);