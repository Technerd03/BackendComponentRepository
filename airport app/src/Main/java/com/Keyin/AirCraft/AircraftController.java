package src.Main.java.com.Keyin.AirCraft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/AirCraft/Aircraft")
public class AircraftController {

    @Autowired
    private AircraftService aircraftService;

    @GetMapping
    public List<Aircrafts> getAllAircraft() {
        return aircraftService.findAll();
    }

    @PostMapping
    public Aircrafts addAircraft(@RequestBody Aircrafts aircraft) {
        return aircraftService.save(aircraft);
    }

    @GetMapping("/{id}")
    public Aircrafts getAircraftById(@PathVariable Long id) {
        return aircraftService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAircraft(@PathVariable Long id) {
        aircraftService.delete(id);
    }
}
