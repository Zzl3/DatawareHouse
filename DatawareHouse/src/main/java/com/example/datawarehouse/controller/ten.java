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
public class ten {
    @Autowired
    @Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @CrossOrigin
    @RequestMapping("/api/SearchFilmByName")
    public Result SearchFilmByName(@RequestBody String filmname) {
        System.out.println(filmname);//
        //String sql = "select distinct(film_name), productid, release_time,type,director,star,vision,last_time from film_id where film_name like \'%"+filmname+"%\' and release_time!=\"\" and release_time!=null and type!=\"\" and type!=null and director!=\"\" and director!=null and vision!=\"\" and vision!=null;";
        String sql = "select distinct(film_name), productid, release_time,type,director,star,vision,last_time from film_id where film_name like \'%"+filmname+"%\';";

        System.out.println(sql);
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        System.out.println(list);
        return  ResultFactory.buildSuccessResult(list);
    }

    @CrossOrigin
    @RequestMapping("/api/SearchWebByname")
    public Result SearchWebByname(@RequestBody String filmname) {
        System.out.println(filmname);//
        String sql = "select distinct * from film_id where film_name=\""+filmname+"\";";
        System.out.println(sql);
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        System.out.println(list);
        return  ResultFactory.buildSuccessResult(list);
    }
}