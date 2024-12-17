package src.Main.java.com.Keyin.Cities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public List<Cities> getAllCities() {
        return cityRepository.findAll();
    }

    public Cities getCityById(Long id) {
        return cityRepository.findById(id).orElse(null);
    }

    public Cities saveCity(Cities city) {
        return cityRepository.save(city);
    }

    public void deleteCity(Long id) {
        cityRepository.deleteById(id);
    }
}