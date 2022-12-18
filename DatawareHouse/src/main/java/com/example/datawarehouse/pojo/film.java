package com.example.datawarehouse.pojo;

import com.example.datawarehouse.pojo.primarykey.DirectorNamePrimaryKey;
import com.example.datawarehouse.pojo.primarykey.FilmPrimaryKey;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "film")
@IdClass(FilmPrimaryKey.class)
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class film implements Serializable {
    @Id
    @Column(name = "filmname", nullable = false)
    String filmname;

    @Id
    @Column(name = "dateid", nullable = false)
    String dateid;

    public String getFilmname() {
        return filmname;
    }

    public void setFilmname(String filmname) {
        this.filmname = filmname;
    }

    public String getDateid() {
        return dateid;
    }

    public void setDateid(String dateid) {
        this.dateid = dateid;
    }
}