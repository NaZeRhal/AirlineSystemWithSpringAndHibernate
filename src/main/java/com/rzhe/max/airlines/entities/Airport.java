package com.rzhe.max.airlines.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "airport")
@NamedQueries({
        @NamedQuery(name = "Airport.findById",
                query = "select distinct a from Airport a " +
                        "left join fetch a.departures ds " +
                        "left join fetch a.arrivals ar " +
                        "where a.id = :id"),
        @NamedQuery(name = "Airport.findAllWithFlights",
                query = "select distinct a from Airport a " +
                        "left join fetch a.departures ds " +
                        "left join fetch a.arrivals ar")
})
public class Airport implements Serializable {
    private Long id;
    private String city;
    private String airportCode;
    private Set<Flight> departures = new HashSet<>();
    private Set<Flight> arrivals = new HashSet<>();

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

    @OneToMany(mappedBy = "departureAirport", cascade = CascadeType.ALL,
            orphanRemoval = true)
    public Set<Flight> getDepartures() {
        return departures;
    }

    public void setDepartures(Set<Flight> departures) {
        this.departures = departures;
    }

    public boolean addDepartures(Flight flight) {
        flight.setDepartureAirport(this);
        return getDepartures().add(flight);
    }

    public void removeDepartures(Flight flight) {
        getDepartures().remove(flight);
    }

    @OneToMany(mappedBy = "arrivalAirport", cascade = CascadeType.ALL,
            orphanRemoval = true)
    public Set<Flight> getArrivals() {
        return arrivals;
    }

    public void setArrivals(Set<Flight> arrivals) {
        this.arrivals = arrivals;
    }

    public boolean addArrivals(Flight flight) {
        flight.setArrivalAirport(this);
        return getArrivals().add(flight);
    }

    public void removeArrivals(Flight flight) {
        getArrivals().remove(flight);
    }

    @Override
    public String toString() {
        return "Airport{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", airportCode='" + airportCode + '\'' +
                '}';
    }
}
