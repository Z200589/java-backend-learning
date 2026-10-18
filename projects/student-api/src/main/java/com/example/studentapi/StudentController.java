package com.example.studentapi;

// TODO 1：导入需要的 Spring 注解

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
// TODO 2：声明控制器注解

@RestController
public class StudentController {

    List<StudentInfo> students = new ArrayList<>();

    StudentInfo s1 = new StudentInfo(1001,"张三",20);
    StudentInfo s2 = new StudentInfo(1002,"李四",21);

    public StudentController(){
        students.add(s1);
        students.add(s2);
    }
    // TODO 3：之后在这里编写 GET /students 方法
    @GetMapping("/students")
    public List<StudentInfo> test(){
        return students;
    }





}