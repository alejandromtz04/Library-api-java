package com.api.rest.model;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table (name = "rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String rol;
    private boolean state = true;

    @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL)
    private List<User> user = new ArrayList<>();

    public Rol (String rol, boolean state) {
        super();
        this.rol = rol;
        this.state = state;
    }

    public long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getRol(){
        return rol;
    }
    public void setRol(String rol){
        this.rol = rol;
    }

    public boolean getState(){
        return state;
    }
    public void setState(boolean state) {
        this.state = state;
    }
}

