package com.rzhe.max.airlines.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "user")
@NamedQueries({
        @NamedQuery(name = "User.findById",
                query = "select u from User u where u.id = :id"),
        @NamedQuery(name = "User.findByLogin",
                query = "select u from User u where u.login = :login")
})
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "{validation.user.firstName.NotBlank.message}")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "{validation.user.lastName.NotBlank.message}")
    @Column(name = "last_name")
    private String lastName;

    @NotBlank(message = "{validation.user.login.NotBlank.message}")
    @Column(name = "login")
    private String login;

    @NotBlank(message = "{validation.user.password.NotBlank.message}")
    @Column(name = "password")
    private String password;

    @ManyToOne(cascade = {
            CascadeType.REFRESH,
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH})
    @JoinColumn(name = "user_type_id")
    private UserType userType;

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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", userType=" + userType +
                '}';
    }
}

