package com.example.datawarehouse.pojo.primarykey;

import java.io.Serializable;
import java.util.Objects;

public class ActMainPrimaryKey implements Serializable {
    private String actor;
    private String film_name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActMainPrimaryKey that = (ActMainPrimaryKey) o;
        return Objects.equals(actor, that.actor) && Objects.equals(film_name, that.film_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actor, film_name);
    }
}
