package com.rzhe.max.airlines.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Flight implements Serializable {
    private String flightCode;
    private Airport departureAirport;
    private Airport arrivalAirport;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private FlightStatus flightStatus;
//    private List<CrewMan> crewManList;

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

//    public List<CrewMan> getCrewManList() {
//        return crewManList;
//    }
//
//    public void setCrewManList(List<CrewMan> crewManList) {
//        this.crewManList = crewManList;
//    }
//
//    public boolean addCrewMan(CrewMan crewMan) {
//        if (crewManList == null) {
//            crewManList = new ArrayList<>();
//            crewManList.add(crewMan);
//            return true;
//        } else {
//            if (crewManList.contains(crewMan)) {
//                return false;
//            }
//        }
//        crewManList.add(crewMan);
//        return true;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;

        Flight flight = (Flight) o;

        if (!getFlightCode().equals(flight.getFlightCode())) return false;
        if (!getDepartureAirport().equals(flight.getDepartureAirport())) return false;
        if (!getArrivalAirport().equals(flight.getArrivalAirport())) return false;
        if (!getDepartureTime().equals(flight.getDepartureTime())) return false;
        if (!getArrivalTime().equals(flight.getArrivalTime())) return false;
        return getFlightStatus().equals(flight.getFlightStatus());
    }

    @Override
    public int hashCode() {
        int result = getFlightCode().hashCode();
        result = 31 * result + getDepartureAirport().hashCode();
        result = 31 * result + getArrivalAirport().hashCode();
        result = 31 * result + getDepartureTime().hashCode();
        result = 31 * result + getArrivalTime().hashCode();
        result = 31 * result + getFlightStatus().hashCode();
        return result;
    }


}

