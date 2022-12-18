package com.example.datawarehouse_hive.controller;

import com.example.datawarehouse_hive.result.Result;
import com.example.datawarehouse_hive.result.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class filmname {
    @Autowired
    @Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @CrossOrigin
    @RequestMapping("/api/SearchByFilmName")
    public Result SearchByFilmName(@RequestBody String filmname) {
        System.out.println(filmname);//0-6代表星期日到星期六
        String sql = "select * from film_vision_new where film_name=\""+filmname+"\"";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        System.out.println(list);
        return  ResultFactory.buildSuccessResult(list);
    }
}