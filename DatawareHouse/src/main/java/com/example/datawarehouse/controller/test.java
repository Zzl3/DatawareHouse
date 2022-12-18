package com.example.datawarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class test {
    @Autowired
    @Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/test")
    public List<Map<String, Object>> test() {
        String sql = "show tables";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        System.out.println(list);
        return list;
    }
}
