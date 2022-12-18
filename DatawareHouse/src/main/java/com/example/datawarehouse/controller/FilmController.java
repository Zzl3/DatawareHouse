package com.example.datawarehouse.controller;

import com.example.datawarehouse.dao.DirectDAO;
import com.example.datawarehouse.dao.FilmDAO;
import com.example.datawarehouse.pojo.direct;
import com.example.datawarehouse.pojo.film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FilmController {
    @Autowired
    FilmDAO filmDAO;
    @CrossOrigin
    @PostMapping(value = "/api/SearchByFilmName")
    @ResponseBody
    public List<film> SearchByFilmName(@RequestBody String name) {
        List<film> films=filmDAO.findByFilmnameLike("%"+name+"%");
        return films;
    }
}