-- Creating Tables
CREATE TABLE Users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Categories (
    category_id INT AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE Products (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    stock INT NOT NULL,
    category_id INT,
    FOREIGN KEY (category_id) REFERENCES Categories(category_id) ON DELETE SET NULL
);

CREATE TABLE Orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total_price DECIMAL(10,2),
    status ENUM('Pending', 'Shipped', 'Delivered', 'Cancelled') NOT NULL,
    FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE CASCADE
);

CREATE TABLE Order_Items (
    order_item_id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES Orders(order_id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES Products(product_id) ON DELETE CASCADE
);

CREATE TABLE Payments (
    payment_id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT UNIQUE NOT NULL,
    payment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    amount DECIMAL(10,2) NOT NULL,
    payment_method ENUM('Credit Card', 'Debit Card', 'PayPal', 'Cash') NOT NULL,
    status ENUM('Pending', 'Completed', 'Failed') NOT NULL,
    FOREIGN KEY (order_id) REFERENCES Orders(order_id) ON DELETE CASCADE
);

-- Insert Data
INSERT INTO Users (username, email) VALUES
('alice', 'alice@example.com'),
('bob', 'bob@example.com'),
('charlie', 'charlie@example.com'),
('david', 'david@example.com'),
('emma', 'emma@example.com');

INSERT INTO Categories (category_name) VALUES
('Electronics'),
('Clothing'),
('Books'),
('Home & Kitchen');

INSERT INTO Products (name, price, stock, category_id) VALUES
('Smartphone', 599.99, 50, 1),
('Laptop', 999.99, 30, 1),
('T-Shirt', 19.99, 100, 2),
('Jeans', 49.99, 60, 2),
('Cookbook', 29.99, 40, 3),
('Fiction Novel', 15.99, 80, 3),
('Blender', 79.99, 25, 4);

INSERT INTO Orders (user_id, total_price, status) VALUES
(1, 619.98, 'Shipped'),
(2, 1069.98, 'Pending'),
(3, 29.99, 'Delivered'),
(4, 99.98, 'Cancelled');

INSERT INTO Order_Items (order_id, product_id, quantity, price) VALUES
(1, 1, 1, 599.99),
(1, 3, 1, 19.99),
(2, 2, 1, 999.99),
(2, 4, 1, 49.99),
(3, 5, 1, 29.99),
(4, 6, 2, 15.99);

INSERT INTO Payments (order_id, amount, payment_method, status) VALUES
(1, 619.98, 'Credit Card', 'Completed'),
(2, 1069.98, 'PayPal', 'Pending'),
(3, 29.99, 'Debit Card', 'Completed'),
(4, 99.98, 'Credit Card', 'Failed');