package src.Main.java.com.Keyin.Gates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gates")
public class GateController {
    @Autowired
    private GateService gateService;

    @GetMapping
    public List<Gate> getAllGates() {
        return gateService.findAll();
    }

    @PostMapping
    public Gate addGate(@RequestBody Gate gate) {
        return gateService.save(gate);
    }

    @GetMapping("/{id}")
    public Gate getGateById(@PathVariable Long id) {
        return gateService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteGate(@PathVariable Long id) {
        gateService.delete(id);
    }
}
