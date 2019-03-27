package com.example.demo.service;

import com.example.demo.dao.StudentDao;
import com.example.demo.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liuchen25 on 2018/6/22.
 */
@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public Student queryById(String id) {
        return studentDao.queryById(id);
    }
}
