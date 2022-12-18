package com.example.datawarehouse.controller;

import com.example.datawarehouse.dao.ActMainDAO;
import com.example.datawarehouse.dao.DirectDAO;
import com.example.datawarehouse.pojo.act_main;
import com.example.datawarehouse.pojo.direct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class DirectController {
    @Autowired
    DirectDAO directDAO;

    @CrossOrigin
    @PostMapping(value = "/api/SearchByDirector")
    @ResponseBody
    public List<direct> SearchByDirector(@RequestBody String name) {
        List<direct> films=directDAO.findByDirectornameLike("%"+name+"%");
        return films;
    }
}