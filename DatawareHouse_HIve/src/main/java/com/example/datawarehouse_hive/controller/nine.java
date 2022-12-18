package com.example.datawarehouse_hive.controller;

import com.example.datawarehouse_hive.entity.YearDirector;
import com.example.datawarehouse_hive.entity.YearType;
import com.example.datawarehouse_hive.result.Result;
import com.example.datawarehouse_hive.result.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class nine {
    @Autowired
    @Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/SearchByTD")
    public Result SearchByTD(@RequestBody YearDirector yearDirector) {
        System.out.println(yearDirector);//0-6代表星期日到星期六
        String sql = "select * from film_time_director where film_year="+yearDirector.getYear() +" and director=\""+yearDirector.getDirector()+"\"";
        System.out.println(sql);
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        System.out.println(list);
        return  ResultFactory.buildSuccessResult(list);
    }

    @RequestMapping("/SearchByTT")
    public Result SearchByTD(@RequestBody YearType yearType) {
        System.out.println(yearType);//0-6代表星期日到星期六
        String sql = "select * from film_time_type where film_year="+yearType.getYear() +" and type=\""+yearType.getType()+"\"";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        System.out.println(list);
        return  ResultFactory.buildSuccessResult(list);
    }
}

