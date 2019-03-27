package com.example.demo.controller;

import com.example.demo.domain.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liuchen25 on 2018/6/22.
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/queryById",produces = MediaType.APPLICATION_JSON_VALUE)
    public Student queryById(String id) {
        Student student = studentService.queryById(id);
        return student;
    }

    @RequestMapping(value = "/test", produces = MediaType.APPLICATION_XML_VALUE)
    public Student testXml(String id) {
        Student student = studentService.queryById(id);
        return student;
    }
}
