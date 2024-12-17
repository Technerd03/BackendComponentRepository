package src.Main.java.com.Keyin.Passengers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {
    @Autowired
    private PassengerRepository passengerRepository;

    public List<Passengers> findAll() {
        return passengerRepository.findAll();
    }

    public Passengers save(Passengers passenger) {
        return passengerRepository.save(passenger);
    }

    public Passengers findById(Long id) {
        return passengerRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        passengerRepository.deleteById(id);
    }
}
