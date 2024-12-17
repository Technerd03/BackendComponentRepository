package src.Main.java.com.Keyin.Gates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GateService {
    @Autowired
    private GateRepository gateRepository;

    public List<Gate> findAll() {
        return gateRepository.findAll();
    }

    public Gate save(Gate gate) {
        return gateRepository.save(gate);
    }

    public Gate findById(Long id) {
        return gateRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        gateRepository.deleteById(id);
    }
}