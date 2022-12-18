package com.example.datawarehouse.dao;

import com.example.datawarehouse.pojo.act_main;
import com.example.datawarehouse.pojo.direct;
import com.example.datawarehouse.pojo.primarykey.ActMainPrimaryKey;
import com.example.datawarehouse.pojo.primarykey.DirectorNamePrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DirectDAO extends JpaRepository<direct, DirectorNamePrimaryKey> {
    List<direct> findAll(); //查询全部
    List<direct> findByDirectornameLike(String a);
}