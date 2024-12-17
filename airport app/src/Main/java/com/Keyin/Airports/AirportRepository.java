package src.Main.java.com.Keyin.Airports;

import src.Main.java.com.Keyin.Airports.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Long> {
}