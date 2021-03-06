package com.rzhe.max.airlines.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user_type")
@NamedQueries({
        @NamedQuery(name = "UserType.findById",
                query = "select distinct u from UserType u " +
                        "left join fetch u.userSet us where u.id = :id"),
        @NamedQuery(name = "UserType.findAllWithUsers",
                query = "select distinct u from UserType u " +
                        "left join fetch u.userSet us ")
})
public class UserType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_type_name")
    private String name;

    @OneToMany(mappedBy = "userType", cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<User> userSet = new HashSet<>();

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

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }

    public boolean addUser(User user) {
        user.setUserType(this);
        return getUserSet().add(user);
    }

    public void removeUser(User user) {
        getUserSet().remove(user);
    }

    @Override
    public String toString() {
        return "UserType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
