CREATE TABLE gate (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    gate_number VARCHAR(10) NOT NULL,
    airport_id BIGINT,
    FOREIGN KEY (airport_id) REFERENCES airport(id)
    FOREIGN KEY (airline_id) REFERENCES airline(id)
);