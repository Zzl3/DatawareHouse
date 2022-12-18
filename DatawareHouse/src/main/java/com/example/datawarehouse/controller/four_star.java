package com.example.datawarehouse.controller;

import com.example.datawarehouse.result.Result;
import com.example.datawarehouse.result.ResultFactory;
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
public class four_star {
    @Autowired
    @Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @CrossOrigin
    @RequestMapping("/api/SearchByMainStar")
    public Result SearchByMainStar(@RequestBody String starMain) {
        System.out.println(starMain);//0-6代表星期日到星期六
        String sql = "select * from film_starMain where starMain=\""+starMain+"\"";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        System.out.println(list);
        return  ResultFactory.buildSuccessResult(list);
    }

    @CrossOrigin
    @RequestMapping("/api/SearchByStar")
    public Result SearchByStar(@RequestBody String star) {
        System.out.println(star);//0-6代表星期日到星期六
        String sql = "select * from film_star where star=\""+star+"\"";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        System.out.println(list);
        return  ResultFactory.buildSuccessResult(list);
    }
}