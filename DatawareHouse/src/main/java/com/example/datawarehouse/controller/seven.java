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
public class seven {
    @Autowired
    @Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @CrossOrigin
    @RequestMapping("/api/SearchByScore")
    public Result SearchByScore(@RequestBody String  score) {
        System.out.println(score);//0-6代表星期日到星期六
        String sql = "select distinct film_name from film_review where film_name!=\"\" and score >="+score;
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        System.out.println(list);
        return  ResultFactory.buildSuccessResult(list);
    }

    @CrossOrigin
    @RequestMapping("/api/SearchByActive")
    public Result SearchByActive() {
        String sql = "select distinct film_name from film_review where is_active=1 and film_name!=\"\"";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        System.out.println(list);
        return  ResultFactory.buildSuccessResult(list);
    }
}
