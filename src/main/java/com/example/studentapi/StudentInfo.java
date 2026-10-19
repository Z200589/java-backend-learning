
package com.example.studentapi;

import java.util.List;

public class StudentInfo {

    // TODO 1：声明三个 private 字段
    // id：int
    private int id;
    // name：String
    private String name;
    // age：int
    private int age;

    // TODO 2：编写构造方法
    // 接收 id、name、age 三个参数
    // 将参数赋值给当前对象的字段

    public StudentInfo(int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
