package com.rzhe.max.airlines.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "airport")
//@NamedQueries({
//        @NamedQuery(name = "Airport.findById")
//})
public class Airport implements Serializable {
    private Long id;
    private String city;
    private String airportCode;
    private Set<Flight> flights = new HashSet<>();
//    private Set<Flight> arrivals = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "airport_code")
    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

//    @OneToMany(mappedBy = "airports", cascade = CascadeType.ALL,
//            orphanRemoval = true, fetch = FetchType.EAGER)
//    public Set<Flight> getFlights() {
//        return flights;
//    }
//
//    public void setFlights(Set<Flight> flights) {
//        this.flights = flights;
//    }
//
//    public boolean addDeparture(Flight flight) {
//        flight.setDepartureAirport(this);
//        return getFlights().add(flight);
//    }
//
//    public void removeDeparture(Flight flight) {
//        getFlights().remove(flight);
//    }

    @Override
    public String toString() {
        return "Airport{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", airportCode='" + airportCode + '\'' +
                '}';
    }
}
