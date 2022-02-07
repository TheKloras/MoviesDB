package com.company.entity;

import javax.persistence.*;

@Entity
@Table(name = "movies")
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code")
    private int code;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "movieThreater", cascade = CascadeType.ALL)
    private int movie;

    public Movies(String name, String test){

    }
    public Movies(int code, String name, int movie) {
        this.code = code;
        this.name = name;
        this.movie = movie;
    }

    public Movies(String name, int movie) {
        this.name = name;
        this.movie = movie;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMovie() {
        return movie;
    }

    public void setMovie(int movie) {
        this.movie = movie;
    }
}
