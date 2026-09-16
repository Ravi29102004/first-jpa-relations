package com.demo.first.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  id;

    private String name;

    public Tag(){

    }

    public Tag(String name){
        this.name=name;
    }


    @ManyToMany(mappedBy = "tags")
    @JsonIgnore   //Jsonignore iss liye logic build kiye hai agar jo json ke data wrapup kiye hai wo infinitely times de raha tha
    private List<Post> posts;
}
