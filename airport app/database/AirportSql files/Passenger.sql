CREATE TABLE passenger (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    phone_number VARCHAR(15) UNIQUE,
    city_id INT,
    FOREIGN KEY (city_id) REFERENCES city(id) ON DELETE SET NULL
);