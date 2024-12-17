package src.Main.java.com.Keyin.Airline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirlineService {
    @Autowired
    private AirlineRepository airlineRepository;

    public List<Airline> findAll() {
        return airlineRepository.findAll();
    }

    public Airline save(Airline airline) {
        return airlineRepository.save(airline);
    }

    public Airline findById(Long id) {
        return airlineRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        airlineRepository.deleteById(id);
    }
}