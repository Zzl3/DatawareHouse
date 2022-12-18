package com.example.datawarehouse.controller;

import com.example.datawarehouse.dao.ActDAO;
import com.example.datawarehouse.pojo.act;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ActController {
    @Autowired
    ActDAO actDAO;

    @CrossOrigin
    @PostMapping(value = "/api/SearchByStar")
    @ResponseBody
    public List<act> SearchByStar(@RequestBody String name) {
        List<act> films=actDAO.findByActorLike("%"+name+"%");
        return films;
    }
}
