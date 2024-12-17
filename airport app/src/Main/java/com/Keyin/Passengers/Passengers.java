package src.Main.java.com.Keyin.Passengers;

import javax.persistence.*;

import src.Main.java.com.Keyin.Cities.Cities;

import java.util.List;

@Entity
public class Passengers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private Cities city;

    @ManyToMany(mappedBy = "passengers")
    private List<Aircrafts> aircraftList;
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public Cities getCity() { return city; }
    public void setCity(Cities city) { this.city = city; }
    
    public List<Aircrafts> getAircraftList() { return aircraftList; }
    public void setAircraftList(List<Aircrafts> aircraftList) { this.aircraftList = aircraftList; }
}