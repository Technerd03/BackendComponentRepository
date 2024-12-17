CREATE TABLE aircraft_airport (
    aircraft_id INT,
    airport_id INT,
    PRIMARY KEY (aircraft_id, airport_id),
    FOREIGN KEY (aircraft_id) REFERENCES aircraft(id) ON DELETE CASCADE,
    FOREIGN KEY (airport_id) REFERENCES airport(id) ON DELETE CASCADE
);