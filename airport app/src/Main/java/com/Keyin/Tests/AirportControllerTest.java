package src.Main.java.com.Keyin.Tests;

import src.Main.java.com.Keyin.Airports.Airport;
import src.Main.java.com.Keyin.Airports.AirportService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import src.Main.java.com.Keyin.Airports.AirportController;

import java.util.List;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AirportController.class)
class AirportControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AirportService airportService;

    @Test
    void testGetAllAirports() throws Exception {
        List<Airport> airports = List.of(new Airport(1L, "WBA", "WBA123"), new Airport(2L, "LAX", "LAX456"));
        when(airportService.getAllAirports()).thenReturn(airports);

        mockMvc.perform(get("/api/airports"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2));
    }

    @Test
    void testGetAirportById() throws Exception {
        Airport airport = new Airport(1L, "WBA", "WBA123");
        when(airportService.getAirportById(1L)).thenReturn(airport);

        mockMvc.perform(get("/api/airports/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("WBA"));
    }

    @Test
    void testCreateAirport() throws Exception {
        Airport airport = new Airport(null, "ORD", "ORD789");
        when(airportService.createAirport(any(Airport.class))).thenReturn(new Airport(3L, "ORD", "ORD789"));

        mockMvc.perform(post("/api/airports")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"ORD\", \"code\": \"ORD789\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(3));
    }

    @Test
    void testUpdateAirport() throws Exception {
        Airport updatedAirport = new Airport(1L, "SFO International", "SFO111");
        when(airportService.updateAirport(eq(1L), any(Airport.class))).thenReturn(updatedAirport);

        mockMvc.perform(put("/api/airports/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"SFO International\", \"code\": \"SFO111\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("SFO International"));
    }

    @Test
    void testDeleteAirport() throws Exception {
        doNothing().when(airportService).deleteAirport(1L);

        mockMvc.perform(delete("/api/airports/1"))
                .andExpect(status().isOk());
    }
}
