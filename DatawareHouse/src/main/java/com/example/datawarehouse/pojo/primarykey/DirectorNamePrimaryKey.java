package com.example.datawarehouse.pojo.primarykey;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;


@Data
public class DirectorNamePrimaryKey implements Serializable {
    private String directorname;
    private String film_name;
}
