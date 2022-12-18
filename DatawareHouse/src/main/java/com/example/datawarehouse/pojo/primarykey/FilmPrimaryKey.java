package com.example.datawarehouse.pojo.primarykey;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
public class FilmPrimaryKey implements Serializable {
    private String filmname;
    private String dateid;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmPrimaryKey that = (FilmPrimaryKey) o;
        return Objects.equals(filmname, that.filmname) && Objects.equals(dateid, that.dateid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmname, dateid);
    }
}