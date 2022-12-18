package com.example.datawarehouse.controller;

import com.example.datawarehouse.result.Result;
import com.example.datawarehouse.result.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class five {
    @Autowired
    @Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @CrossOrigin
    @RequestMapping("/api/SearchByAA")
    public Result SearchByAA() {
        String sql = "select * from count_star_star limit 1";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        System.out.println(list);
        return  ResultFactory.buildSuccessResult(list);
    }

    @CrossOrigin
    @RequestMapping("/api/SearchByDA")
    public Result SearchByDA() {
        String sql = "select * from count_director_star limit 1";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        System.out.println(list);
        return  ResultFactory.buildSuccessResult(list);
    }
    @CrossOrigin
    @RequestMapping("/api/SearchByDD")
    public Result SearchByDD() {
        String sql = "select * from count_director_director limit 1";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        System.out.println(list);
        return  ResultFactory.buildSuccessResult(list);
    }
}
