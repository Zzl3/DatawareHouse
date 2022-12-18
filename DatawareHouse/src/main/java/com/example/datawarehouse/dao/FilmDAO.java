package com.example.datawarehouse.dao;

import com.example.datawarehouse.pojo.direct;
import com.example.datawarehouse.pojo.film;
import com.example.datawarehouse.pojo.primarykey.DirectorNamePrimaryKey;
import com.example.datawarehouse.pojo.primarykey.FilmPrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmDAO extends JpaRepository<film, FilmPrimaryKey> {
    List<film> findAll(); //查询全部
    List<film> findByFilmnameLike(String a);//根据电影名查询
}