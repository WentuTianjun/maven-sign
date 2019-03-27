package com.example.demo.dao;

import com.example.demo.domain.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by liuchen25 on 2018/6/22.
 */
@Mapper
public interface StudentDao {
    Student queryById(String id);
}
