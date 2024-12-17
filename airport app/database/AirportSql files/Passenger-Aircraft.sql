CREATE TABLE passenger_aircraft (
    passenger_id INT,
    aircraft_id INT,
    PRIMARY KEY (passenger_id, aircraft_id),
    FOREIGN KEY (passenger_id) REFERENCES passenger(id) ON DELETE CASCADE,
    FOREIGN KEY (aircraft_id) REFERENCES aircraft(id) ON DELETE CASCADE
);