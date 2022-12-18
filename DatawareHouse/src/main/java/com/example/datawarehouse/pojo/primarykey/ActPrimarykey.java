package com.example.datawarehouse.pojo.primarykey;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
public class ActPrimarykey implements Serializable {
    private String actor;
    private String film_name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActPrimarykey that = (ActPrimarykey) o;
        return Objects.equals(actor, that.actor) && Objects.equals(film_name, that.film_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actor, film_name);
    }
}
