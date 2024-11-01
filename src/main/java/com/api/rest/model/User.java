package com.api.rest.model;

import jakarta.persistence.*;

@Entity
@Table (name = "user_model")
public class User {

    @Id 
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private long id;

    private String name;
    private String lastName;
    private byte age; 
    private boolean state = true;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "userContactId", referencedColumnName = "id")
    private UserContact userContact;

    // Constructor 
    public User(){}
    public User (String name, String lastName, byte age, boolean state, UserContact userContact) {
        super();
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.state = state;
        this.userContact = userContact;
    }


    //Getters and setters
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public byte getAge() {
        return age;
    }
    public void setAge(byte age) {
        this.age = age;
    }

    public boolean getState() {
        return state;
    }
    public void setState(boolean state) {
        this.state = state;
    }

    public UserContact getRol(){
        return userContact;
    }
    public void setRol(UserContact userContact) {
        this.userContact = userContact;
    }
}
