
package com.example.studentapi;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private final List<StudentInfo> students;

    public StudentService() {
        // TODO 1：创建 List
        List<StudentInfo> studentInfos = new ArrayList<>();
        // TODO 2：添加学号1001的张三，20岁
        studentInfos.add(new StudentInfo(1001,"张三",20));
        studentInfos.add(new StudentInfo(1002,"李四",21));
        // TODO 3：添加学号1002的李四，21岁
        // TODO 4：将 List 保存到 students
        students = studentInfos;
    }
    public StudentInfo findById(int id) {
        // TODO 5：遍历 students
        for(StudentInfo studentInfo : students){
            if(studentInfo.getId() == id){
                return studentInfo;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"学生不存在");
        // TODO 6：找到学号匹配的学生就返回
        // TODO 7：找不到时返回 null
    }

    public List<StudentInfo> findAll(){
        return students;
    }
}
