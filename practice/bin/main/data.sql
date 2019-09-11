DROP TABLE IF EXISTS user;
CREATE TABLE IF NOT EXISTS user (
    id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    user_name VARCHAR(25) NOT NULL,
    password VARCHAR(25) NOT NULL,
    full_name VARCHAR(50) NOT NULL,
    is_admin TINYINT(1) NOT NULL DEFAULT 0
);

INSERT INTO user
(user_name, password, full_name)
VALUES ('taro', 'taropw', 'Taro Yamada');
INSERT INTO user
(user_name, password, full_name)
VALUES ('jiro', 'jiropw', 'Jiro Tanaka');
INSERT INTO user
(user_name, password, full_name)
VALUES ('ichiko', 'ichikopw', 'Ichiko Hayashi');
INSERT INTO user
(user_name, password, full_name, is_admin)
VALUES ('admin', 'admin', '管理者　太郎', 1);

DROP TABLE IF EXISTS goods;
CREATE TABLE IF NOT EXISTS goods (
    id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    goods_name VARCHAR(255) NOT NULL,
    price INT(11) DEFAULT 0,
    updated_at TIMESTAMP NOT NULL DEFAULT now() ON UPDATE now()
);

INSERT INTO goods
(goods_name, price)
VALUES ('Tシャツ', 1000);
INSERT INTO goods
(goods_name, price)
VALUES ('ジャケット', 10000);
INSERT INTO goods
(goods_name, price)
VALUES ('スニーカー', 5000);

DROP TABLE IF EXISTS purchase;
CREATE TABLE IF NOT EXISTS purchase (
	id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	user_id INT(11) NOT NULL,
	goods_id INT(11) NOT NULL,
	item_count INT(11) DEFAULT 0,
	total INT(11) DEFAULT 0,
	created_at TIMESTAMP NOT NULL DEFAULT now() ON UPDATE now()
);