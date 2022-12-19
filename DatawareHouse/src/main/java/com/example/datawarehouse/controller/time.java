package com.example.datawarehouse.controller;

import com.example.datawarehouse.entity.YearMonth;
import com.example.datawarehouse.entity.YearSeason;
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
public class time {
    @Autowired
    @Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemplate;
    //xxx年有多少电影
    @CrossOrigin
    @RequestMapping("/api/SearchByYear")
    public Result countByYear(@RequestBody String year) {
        System.out.println(year);
        String sql = "select distinct film_name,film_year,film_month,film_day,film_week from film_time where film_year=" + year;
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        System.out.println(list);
        return ResultFactory.buildSuccessResult(list);
    }
    @CrossOrigin
    @RequestMapping("/api/SearchByYearMonth")
    public Result countByYearMonth(@RequestBody YearMonth yearMonth) {
        System.out.println(yearMonth);
        String sql = "select distinct film_name,film_year,film_month,film_day,film_week from film_time where film_month="+yearMonth.getMonth()+" and film_year="+yearMonth.getYear();
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        System.out.println(list);
        return ResultFactory.buildSuccessResult(list);
    }
    @CrossOrigin
    @RequestMapping("/api/SearchByYearSeason")
    public Result SearchByYearSeason(@RequestBody YearSeason yearSeason) {
        System.out.println(yearSeason);
        String sql ="";
        if(yearSeason.getSeason()==1){
            sql = "select distinct film_name,film_year,film_month,film_day,film_week from film_time where film_month>=1 and film_month<=3 and film_year="+yearSeason.getYear();
        }else if (yearSeason.getSeason()==2){
            sql = "select distinct film_name,film_year,film_month,film_day,film_week from film_time where film_month>=4 and film_month<=6 and film_year="+yearSeason.getYear();
        }else if (yearSeason.getSeason()==3){
            sql = "select distinct film_name,film_year,film_month,film_day,film_week from film_time where film_month>=7 and film_month<=9 and film_year="+yearSeason.getYear();
        }else if (yearSeason.getSeason()==4){
            sql = "select distinct film_name,film_year,film_month,film_day,film_week from film_time where film_month>=10 and film_month<=12 and film_year="+yearSeason.getYear();
        }else {
            return ResultFactory.buildFailResult("季度错误");
        }
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        System.out.println(list);
        return ResultFactory.buildSuccessResult(list);
    }
    @CrossOrigin
    @RequestMapping("/api/SearchByWeek")
    public Result SearchByWeek(@RequestBody String week) {
        System.out.println(week);//0-6代表星期日到星期六
        String sql = "select * from film_time where film_week="+week;
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        System.out.println(list);
        return  ResultFactory.buildSuccessResult(list);
    }
}