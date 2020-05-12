package com.rzhe.max.airlines.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "flights")
@NamedQueries({
        @NamedQuery(name = "Flight.findById",
                query = "select f from Flight f where f.id = :id")
})
public class Flight implements Serializable {
    private Long id;
    private String flightCode;
    private Airport departureAirport;
    private Airport arrivalAirport;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private FlightStatus flightStatus;

//    private List<Airport> airports = new ArrayList<>();
//    private List<CrewMan> crewManList;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "flight_code")
    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    @ManyToOne
    @JoinColumn(name = "departure_airport_id")
    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airport airport) {
        this.departureAirport = airport;
    }

    @ManyToOne
    @JoinColumn(name = "arrival_airport_id")
    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    @Column(name = "departure_time")
    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    @Column(name = "arrival_time")
    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @ManyToOne
    @JoinColumn(name = "flight_status_id")
    public FlightStatus getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(FlightStatus flightStatus) {
        this.flightStatus = flightStatus;
    }

//    @ManyToMany
//    public List<Airport> getAirports() {
//        return airports;
//    }
//
//    public void setAirports(List<Airport> airports) {
//        this.airports = airports;
//    }
//
//    public boolean addAirports(Airport departureAirport, Airport arrivalAirport) {
//
//    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", flightCode='" + flightCode + '\'' +
                ", departureAirport=" + departureAirport +
                ", arrivalAirport=" + arrivalAirport +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", flightStatus=" + flightStatus +
                '}';
    }
}

