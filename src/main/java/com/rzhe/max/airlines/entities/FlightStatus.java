package com.rzhe.max.airlines.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "flight_status")
@NamedQueries({
        @NamedQuery(name = "FlightStatus.findById",
                query = "select distinct f from FlightStatus f " +
                        "left join fetch f.flights fs where f.id = :id"),
        @NamedQuery(name = "FlightStatus.findAllWithFlights",
                query = "select distinct f from FlightStatus f " +
                        "left join fetch f.flights fs")
})
public class FlightStatus implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "flight_status_name")
    private String name;

    @OneToMany(mappedBy = "flightStatus", cascade = {
            CascadeType.REFRESH,
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH})
    private Set<Flight> flights = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Set<Flight> getFlights() {
        return flights;
    }

    public void setFlights(Set<Flight> flights) {
        this.flights = flights;
    }

    public boolean addFlight(Flight flight) {
        flight.setFlightStatus(this);
        return getFlights().add(flight);
    }

    public void removeFlight(Flight flight) {
        getFlights().remove(flight);
    }

    @Override
    public String toString() {
        return "FlightStatusDao{" +
                "name='" + name + '\'' +
                '}';
    }
}
