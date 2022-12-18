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
public class eight {
    @Autowired
    @Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @CrossOrigin
    @RequestMapping("/api/SearchAAByType")
    public Result SearchAAByType(@RequestBody String type) {
        String sql1 = "select film_name from film_review_type where type=\""+type+"\""+" order by amount desc limit 1";
        System.out.println(sql1);
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql1);
        System.out.println(list);
        String film_name=(String) list.get(0).get("film_name");
        System.out.println("film_name:"+film_name);
        String sql2="select star from film_star_new where film_name=\""+film_name+"\"";
        List<Map<String, Object>> list1 = jdbcTemplate.queryForList(sql2);
        System.out.println(list1);
        return  ResultFactory.buildSuccessResult(list1);
    }
}

