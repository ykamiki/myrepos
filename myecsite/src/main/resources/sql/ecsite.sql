CREATE DATABASE IF NOT EXISTS ecsite;
use ecsite;

CREATE TABLE user (
    id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    user_name VARCHAR(25) NOT NULL,
    password VARCHAR(25) NOT NULL,
    full_name VARCHAR(50) NOT NULL
);

INSERT INTO user
(user_name, password, full_name)
VALUES ('taro', '123', 'Taro Yamada');
INSERT INTO user
(user_name, password, full_name)
VALUES ('jiro', '123', 'Jiro Tanaka');

CREATE TABLE product (
    id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    product_name VARCHAR(255) NOT NULL,
    price INT(11) DEFAULT 0
);

INSERT INTO product
(product_name, price)
VALUES ('Tシャツ', 1000);
INSERT INTO product
(product_name, price)
VALUES ('ジャケット', 5000);
INSERT INTO product
(product_name, price)
VALUES ('スニーカー', 5000);

CREATE TABLE purchase (
	id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	user_id INT(11) NOT NULL,
    product_id INT(11) NOT NULL,
    count INT(11) DEFAULT 0,
    total INT(11) DEFAULT 0,
    purchase_date DATE
);