package src.Main.java.com.Keyin.Cities;

import src.Main.java.com.Keyin.Cities.Cities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Cities/Cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping
    public List<Cities> getAllCities() {
        return cityService.findAll();
    }

    @PostMapping
    public Cities addCity(@RequestBody Cities city) {
        return cityService.save(city);
    }

    @GetMapping("/{id}")
    public Cities getCityById(@PathVariable Long id) {
        return cityService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable Long id) {
        cityService.delete(id);
    }
}
