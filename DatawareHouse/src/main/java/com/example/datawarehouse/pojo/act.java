package com.example.datawarehouse.pojo;

import com.example.datawarehouse.pojo.primarykey.ActPrimarykey;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "act")
@IdClass(ActPrimarykey.class)
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class act implements Serializable{
    @Id
    @Column(name = "actor", nullable = false)
    String actor;

    @Id
    @Column(name = "film_name", nullable = false)
    String film_name;

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getFilm_name() {
        return film_name;
    }

    public void setFilm_name(String film_name) {
        this.film_name = film_name;
    }
}
