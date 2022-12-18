package com.example.datawarehouse.controller;

import com.example.datawarehouse.dao.ActDAO;
import com.example.datawarehouse.dao.ActMainDAO;
import com.example.datawarehouse.pojo.act;
import com.example.datawarehouse.pojo.act_main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActMainController {
    @Autowired
    ActMainDAO actDAO;

    @CrossOrigin
    @PostMapping(value = "/api/SearchByMainStar")
    @ResponseBody
    public List<act_main> SearchByMainStar(@RequestBody String name) {
        List<act_main> films=actDAO.findByActorLike("%"+name+"%");
        return films;
    }
}
