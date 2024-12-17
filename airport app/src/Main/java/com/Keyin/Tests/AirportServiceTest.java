package src.Main.java.com.Keyin.Tests;

import src.Main.java.com.Keyin.Airports.AirportService;
import src.Main.java.com.Keyin.Airports.AirportRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AirportServiceTest {

    @Mock
    private AirportRepository airportRepository;

    @InjectMocks
    private AirportService airportService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllAirports() {
        List<Airport> airports = List.of(new Airport(1L, "JFK", "JFK123"), new Airport(2L, "LAX", "LAX456"));
        when(airportRepository.findAll()).thenReturn(airports);
        
        List<Airport> result = airportService.getAllAirports();
        assertEquals(2, result.size());
    }

    @Test
    void testGetAirportById() {
        Airport airport = new Airport(1L, "JFK", "JFK123");
        when(airportRepository.findById(1L)).thenReturn(Optional.of(airport));

        Airport result = airportService.getAirportById(1L);
        assertNotNull(result);
        assertEquals("JFK", result.getName());
    }

    @Test
    void testCreateAirport() {
        Airport airport = new Airport(null, "ORD", "ORD789");
        when(airportRepository.save(airport)).thenReturn(new Airport(3L, "ORD", "ORD789"));

        Airport result = airportService.createAirport(airport);
        assertNotNull(result);
        assertEquals(3L, result .getId());
    }

    @Test
    void testUpdateAirport() {
        Airport existingAirport = new Airport(1L, "SFO", "SFO000");
        Airport updatedDetails = new Airport(null, "SFO International", "SFO111");

        when(airportRepository.findById(1L)).thenReturn(Optional.of(existingAirport));
        when(airportRepository.save(any(Airport.class))).thenReturn(updatedDetails);

        Airport result = airportService.updateAirport(1L, updatedDetails);
        assertEquals("SFO International", result.getName());
        assertEquals("SFO111", result.getCode());
    }

    @Test
    void testDeleteAirport() {
        Airport airport = new Airport(1L, "JFK", "JFK123");
        when(airportRepository.findById(1L)).thenReturn(Optional.of(airport));

        assertDoesNotThrow(() -> airportService.deleteAirport(1L));
        verify(airportRepository, times(1)).delete(airport);
    }
}