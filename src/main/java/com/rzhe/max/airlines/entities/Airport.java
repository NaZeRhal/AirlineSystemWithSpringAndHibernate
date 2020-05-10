package com.rzhe.max.airlines.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "airport")
public class Airport implements Serializable {
    private Long id;
    private String city;
    private String airportCode;

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

    @Override
    public String toString() {
        return "Airport{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", airportCode='" + airportCode + '\'' +
                '}';
    }
}
