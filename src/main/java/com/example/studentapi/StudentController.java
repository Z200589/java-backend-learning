package com.example.studentapi;

// TODO 1：导入需要的 Spring 注解

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
// TODO 2：声明控制器注解

@RestController
public class StudentController {

    //List<StudentInfo> students = new ArrayList<>();

   /* StudentInfo s1 = new StudentInfo(1001,"张三",20);
    StudentInfo s2 = new StudentInfo(1002,"李四",21);
*/
    // TODO 3：之后在这里编写 GET /students 方法
    @GetMapping("/students")
    public List<StudentInfo> test(){
        return studentService.findAll();
    }

  //  @GetMapping("/students/{id}")
    /*public StudentInfo findById(@PathVariable int id) {

        // TODO 1：遍历 students 列表

        for(StudentInfo studentInfo : students){
            if(studentInfo.getId() == id){
                return studentInfo;
            }
        }

        // TODO 2：判断学生的 id 是否等于传入的 id

        // TODO 3：找到学生后返回该学生

        // TODO 4：如果遍历结束仍未找到，暂时先留空
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"学生不存在");

    }*/

    private final StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students/{id}")
    public StudentInfo findById(@PathVariable int id){
        return studentService.findById(id);
    }

}