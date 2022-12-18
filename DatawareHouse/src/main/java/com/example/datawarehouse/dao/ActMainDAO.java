package com.example.datawarehouse.dao;

import com.example.datawarehouse.pojo.act;
import com.example.datawarehouse.pojo.act_main;
import com.example.datawarehouse.pojo.primarykey.ActMainPrimaryKey;
import com.example.datawarehouse.pojo.primarykey.ActPrimarykey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActMainDAO extends JpaRepository<act_main, ActMainPrimaryKey> {
    List<act_main> findAll(); //查询全部
    List<act_main> findByActorLike(String a);//根据演员姓名查询
}
