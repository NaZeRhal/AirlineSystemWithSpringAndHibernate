package com.rzhe.max.airlines.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "flights")
@NamedQueries({
        @NamedQuery(name = "Flight.findById",
                query = "select distinct f from Flight f " +
                        "left join fetch f.crewManList c " +
                        "where f.id = :id"),
        @NamedQuery(name = "Flight.findAllWithCrewMen",
                query = "select distinct f from Flight f " +
                        "left join fetch f.crewManList c")
})
public class Flight implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "flight_code")
    private String flightCode;

    @ManyToOne(cascade = {
            CascadeType.REFRESH,
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH})
    @JoinColumn(name = "departure_airport_id")
    private Airport departureAirport;

    @ManyToOne(cascade = {
            CascadeType.REFRESH,
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH})
    @JoinColumn(name = "arrival_airport_id")
    private Airport arrivalAirport;

    @Column(name = "departure_time")
    private LocalDateTime departureTime;

    @Column(name = "arrival_time")
    private LocalDateTime arrivalTime;

    @ManyToOne(cascade = {
            CascadeType.REFRESH,
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH})
    @JoinColumn(name = "flight_status_id")
    private FlightStatus flightStatus;

    @ManyToMany(cascade = {
            CascadeType.REFRESH,
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH})
    @JoinTable(name = "flight_crewman",
            joinColumns = @JoinColumn(name = "flight_id"),
            inverseJoinColumns = @JoinColumn(name = "crewman_id"))
    private Set<CrewMan> crewManList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airport airport) {
        this.departureAirport = airport;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public FlightStatus getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(FlightStatus flightStatus) {
        this.flightStatus = flightStatus;
    }

    public Set<CrewMan> getCrewManList() {
        return crewManList;
    }

    public void setCrewManList(Set<CrewMan> crewManList) {
        this.crewManList = crewManList;
    }

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

