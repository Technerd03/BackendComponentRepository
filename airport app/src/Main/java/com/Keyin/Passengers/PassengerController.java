package src.Main.java.com.Keyin.Passengers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Passengers/Passenger")
public class PassengerController {
    @Autowired
    private PassengerService passengerService;

    @GetMapping
    public List<Passengers> getAllPassengers() {
        return passengerService.findAll();
    }

    @PostMapping
    public Passengers addPassenger(@RequestBody Passengers passenger) {
        return passengerService.save(passenger);
    }

    @GetMapping("/{id}")
    public Passengers getPassengerById(@PathVariable Long id) {
        return passengerService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deletePassenger(@PathVariable Long id) {
        passengerService.delete(id);
    }
}