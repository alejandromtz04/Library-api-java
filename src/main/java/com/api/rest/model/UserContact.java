package com.api.rest.model;


import jakarta.persistence.*;

@Entity
@Table
public class UserContact {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    private String email;
    private String phone;
    private String address;

    @OneToOne(mappedBy = "userContact")
    private User user;

    public UserContact (long id, String email, String phone, String address, User user) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
