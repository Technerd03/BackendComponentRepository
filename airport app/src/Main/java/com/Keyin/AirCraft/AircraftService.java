package src.Main.java.com.Keyin.AirCraft;

import src.Main.java.com.Keyin.AirCraft.Aircraft;
import src.Main.java.com.Keyin.AirCraft.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AircraftService {

    @Autowired
    private AircraftRepository aircraftRepository;

    public List<Aircrafts> findAll() {
        return aircraftRepository.findAll();
    }

    public Aircrafts save(Aircrafts aircraft) {
        return aircraftRepository.save(aircraft);
    }

    public Aircrafts findById(Long id) {
        return aircraftRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        aircraftRepository.deleteById(id);
    }
}
