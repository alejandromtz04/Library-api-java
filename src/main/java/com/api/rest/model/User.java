package com.api.rest.model;

import jakarta.persistence.*;

@Entity
@Table (name = "user-model")
public class User {

    @Id 
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private long id;

    private String name;
    private String lastName;
    private byte age; 
    private boolean state = true;

    @ManyToOne
    @JoinColumn (name = "rol_id")
    private Rol rol;

    // Constructor 

    public User (String name, String lastName, byte age, boolean state, Rol rol) {
        super();
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.state = state;
        this.rol = rol;
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

    public Rol getRol(){
        return rol;
    }
    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
