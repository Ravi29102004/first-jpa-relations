package com.demo.first.app.model;

//POJO-->Plain Old Java Objects
public class User {
    private Integer id;
    private String name;
    private String email;

    public User(Integer id, String name, String email){
        this.id=id;
        this.name=name;
        this.email=email;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
