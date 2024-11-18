package com.copilot.user.mgmt.entity;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "userinfo")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", nullable = false, unique = true)
    private String userName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    //toString method
    @Override
    public String toString() {
        return "UserEntity [id=" + id + ", userName=" + userName + ", password=" + password + ", firstName=" + firstName
                + ", lastName=" + lastName + "]";
    }

    //equals and hashCode method
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        UserEntity userEntity = (UserEntity) obj;
        return id.equals(userEntity.id) && userName.equals(userEntity.userName) && password.equals(userEntity.password)
                && firstName.equals(userEntity.firstName) && lastName.equals(userEntity.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, password, firstName, lastName);
    }
 }