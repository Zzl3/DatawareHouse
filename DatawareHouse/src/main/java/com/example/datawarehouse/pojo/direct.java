package com.example.datawarehouse.pojo;

import com.example.datawarehouse.pojo.primarykey.ActMainPrimaryKey;
import com.example.datawarehouse.pojo.primarykey.DirectorNamePrimaryKey;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "direct")
@IdClass(DirectorNamePrimaryKey.class)
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class direct implements Serializable {
    @Id
    @Column(name = "directorname", nullable = false)
    String directorname;

    @Id
    @Column(name = "film_name", nullable = false)
    String film_name;

    public String getDirectorname() {
        return directorname;
    }

    public void setDirectorname(String directorname) {
        this.directorname = directorname;
    }

    public String getFilm_name() {
        return film_name;
    }

    public void setFilm_name(String film_name) {
        this.film_name = film_name;
    }
}
