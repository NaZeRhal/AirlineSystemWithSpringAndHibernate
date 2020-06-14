package com.rzhe.max.airlines.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "professions")
@NamedQueries({
        @NamedQuery(name = "Profession.findById",
                query = "select distinct p from Profession p " +
                        "left join fetch p.crewMEN c where p.id = :id"),
        @NamedQuery(name = "Profession.findAllWithCrewMen",
                query = "select distinct p from Profession p" +
                        " left join fetch p.crewMEN c")
})
public class Profession implements Serializable {
    private Long id;
    private String name;
    private Set<CrewMan> crewMEN = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "profession_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "profession", cascade = CascadeType.ALL,
            orphanRemoval = true)
    public Set<CrewMan> getCrewMEN() {
        return crewMEN;
    }

    public void setCrewMEN(Set<CrewMan> crewMEN) {
        this.crewMEN = crewMEN;
    }

    public boolean addCrewMan(CrewMan crewMan) {
        crewMan.setProfession(this);
        return getCrewMEN().add(crewMan);
    }

    public void removeCrewMan(CrewMan crewMan) {
        getCrewMEN().remove(crewMan);
    }

    @Override
    public String toString() {
        return "Profession{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
