package com.example.datawarehouse.dao;

import com.example.datawarehouse.pojo.act;
import com.example.datawarehouse.pojo.primarykey.ActPrimarykey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActDAO extends JpaRepository<act, ActPrimarykey> {
    List<act> findAll(); //查询全部
    List<act> findByActorLike(String a);//根据演员姓名查询
}
