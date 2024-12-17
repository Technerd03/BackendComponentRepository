package src.Main.java.com.Keyin.Tests;

import src.Main.java.com.Keyin.Gates.Gate;
import src.Main.java.com.Keyin.Gates.GateRepository;
import src.Main.java.com.Keyin.Gates.GateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GateServiceTest {

    @Mock
    private GateRepository gateRepository;

    @InjectMocks
    private GateService gateService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        List<Gate> gates = List.of(new Gate(1L, "A1"), new Gate(2L, "B2"));
        when(gateRepository.findAll()).thenReturn(gates);

        List<Gate> result = gateService.findAll();
        assertEquals(2, result.size());
    }

    @Test
    void testSave() {
        Gate gate = new Gate(null, "C3");
        when(gateRepository.save(gate)).thenReturn(new Gate(3L, "C3"));

        Gate result = gateService.save(gate);
        assertNotNull(result);
        assertEquals(3L, result.getId());
    }

    @Test
    void testFindById() {
        Gate gate = new Gate(1L, "A1");
        when(gateRepository.findById(1L)).thenReturn(Optional.of(gate));

        Gate result = gateService.findById(1L);
        assertNotNull(result);
        assertEquals("A1", result.getGateNumber());
    }

    @Test
    void testDelete() {
        Gate gate = new Gate(1L, "A1");
        when(gateRepository.findById(1L)).thenReturn(Optional.of(gate));

        assertDoesNotThrow(() -> gateService.delete(1L));
        verify(gateRepository, times(1)).delete(gate);
    }
}