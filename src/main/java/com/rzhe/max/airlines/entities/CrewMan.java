package com.rzhe.max.airlines.entities;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "crew_man")
@NamedQueries({
        @NamedQuery(name = "CrewMan.findById",
                query = "select distinct c from CrewMan c " +
                        "left join fetch c.flights f " +
                        "where c.id = :id"),
        @NamedQuery(name = "CrewMan.findAllWithFlights",
        query = "select distinct c from CrewMan c " +
                "left join fetch c.flights f")
})
public class CrewMan implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;

//    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate dateOfBirth;
    private Profession profession;

    private Set<Flight> flights = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "date_of_birth")
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @ManyToOne
    @JoinColumn(name = "profession_id")
    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    @ManyToMany
    @JoinTable(name = "flight_crewman",
            joinColumns = @JoinColumn(name = "crewman_id"),
            inverseJoinColumns = @JoinColumn(name = "flight_id"))
    public Set<Flight> getFlights() {
        return flights;
    }

    public void setFlights(Set<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public String toString() {
        return "CrewMan{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", profession=" + profession +
                '}';
    }
}
