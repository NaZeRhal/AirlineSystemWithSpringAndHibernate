package com.rzhe.max.airlines.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "flight_status")
public class FlightStatus implements Serializable {
    private Long id;
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "flight_status_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "FlightStatus{" +
                "name='" + name + '\'' +
                '}';
    }
}
