package com.rzhe.max.airlines.entities;

import com.rzhe.max.airlines.utils.LocalDateFormatter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Locale;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "{validation.crewMan.firstName.NotBlank.message}")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "{validation.crewMan.lastName.NotBlank.message}")
    @Column(name = "last_name")
    private String lastName;

    @NotNull(message = "{validation.crewMan.dateOfBirth.NotNull.message}")
    @Past
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @ManyToOne(cascade = {
            CascadeType.REFRESH,
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH})
    @JoinColumn(name = "profession_id")
    private Profession profession;

    @ManyToMany(cascade = {
            CascadeType.REFRESH,
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH})
    @JoinTable(name = "flight_crewman",
            joinColumns = @JoinColumn(name = "crewman_id"),
            inverseJoinColumns = @JoinColumn(name = "flight_id"))
    private Set<Flight> flights = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public Set<Flight> getFlights() {
        return flights;
    }

    public void setFlights(Set<Flight> flights) {
        this.flights = flights;
    }

    @Transient
    public String getBirthDateString() {
        String birthDateString = "";
        if (dateOfBirth != null) {
            LocalDateFormatter formatter = new LocalDateFormatter();
            birthDateString = formatter.print(dateOfBirth, Locale.getDefault());
        }
        return birthDateString;
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
