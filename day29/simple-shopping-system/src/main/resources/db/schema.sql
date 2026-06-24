DROP DATABASE IF EXISTS simple_shop;
CREATE DATABASE simple_shop DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE simple_shop;

CREATE TABLE members (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(100),
    phone VARCHAR(30),
    role VARCHAR(20) NOT NULL DEFAULT 'USER',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE products (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    stock INT NOT NULL DEFAULT 0,
    description VARCHAR(255)
);

CREATE TABLE cart_items (
    id INT PRIMARY KEY AUTO_INCREMENT,
    member_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_cart_member FOREIGN KEY (member_id) REFERENCES members(id) ON DELETE CASCADE,
    CONSTRAINT fk_cart_product FOREIGN KEY (product_id) REFERENCES products(id) ON DELETE CASCADE
);

INSERT INTO members(username, password, name, email, phone, role) VALUES
('admin', 'admin123', '管理者', 'admin@example.com', '0911000000', 'ADMIN'),
('user', 'user123', '一般會員', 'user@example.com', '0922000000', 'USER');

INSERT INTO products(name, price, stock, description) VALUES
('Java 入門課程', 3500, 20, '適合零基礎學員'),
('Spring Boot 實戰課程', 6800, 15, '含 MVC、DAO、MySQL'),
('AI 工具應用課程', 5200, 12, 'ChatGPT 與自動化應用'),
('MySQL 資料庫課程', 4200, 18, '資料表設計與 SQL 查詢');
