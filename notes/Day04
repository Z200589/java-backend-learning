# Day04 Java学习总结

## 一、今日学习内容

今天主要学习 Java 面向对象进阶，并将之前的学生管理系统进行业务层拆分。

核心内容：

- private封装
- getter/setter方法
- 构造方法
- this关键字
- Service业务层设计思想
- HashMap在业务中的应用
- CRUD基本操作

---

# 二、知识点总结

## 1. private封装

private用于隐藏类内部的数据，避免外部直接修改对象状态。

例如：

```java
private String name;
```

外部不能直接：

```java
student.name = "张三";
```

而应该通过：

```java
student.setName("张三");
```

这样可以在修改数据时增加校验逻辑，提高代码安全性和可维护性。

---

## 2. 构造方法

构造方法用于创建对象时初始化成员变量。

特点：

- 方法名必须和类名一致
- 没有返回值类型
- 创建对象时自动调用


示例：

```java
public Student(int id,String name,int age){

    this.id = id;
    this.name = name;
    this.age = age;

}
```

---

## 3. this关键字

this表示当前对象。

例如：

```java
public Student(int id){

    this.id = id;

}
```

其中：

- this.id：当前对象的成员变量
- id：构造方法传入的参数

作用是区分成员变量和局部变量。

---

# 三、项目结构优化

之前：

```
Main
 |
 |-- 添加学生
 |-- 删除学生
 |-- 查询学生
```

所有业务逻辑集中在一个类中，不利于维护。


今天优化为：

```
Day04

Student.java

        ↓

StudentService.java

        ↓

Test.java
```

职责划分：

## Student

负责保存学生信息。

包含：

- id
- name
- age


## StudentService

负责学生业务逻辑。

包含：

- 添加学生
- 查询学生
- 修改学生
- 删除学生


## Test

负责测试业务功能。

---

# 四、StudentService实现

## 1. 添加学生

方法：

```java
public boolean addStudent(Student student)
```

实现逻辑：

1. 判断学号是否存在
2. 不存在则添加
3. 存在则拒绝添加


核心代码：

```java
if(!students.containsKey(student.getId())){

    students.put(student.getId(),student);

    return true;

}

return false;
```

---

## 2. 查询学生

方法：

```java
public Student findStudentById(int id)
```

使用：

```java
students.get(id)
```

HashMap特点：

- key存在：返回value
- key不存在：返回null


---

## 3. 删除学生

方法：

```java
public boolean deleteStudent(int id)
```

使用：

```java
students.remove(id)
```

通过返回值判断删除是否成功。


---

## 4. 修改学生

方法：

```java
public boolean updateStudent(Student student)
```

逻辑：

1. 判断学生是否存在
2. 存在则使用put替换旧对象
3. 返回修改结果


---

# 五、今日遇到的问题

## 1. addStudent逻辑判断错误

第一次实现：

```java
if(students.containsKey(student.getId()))
```

错误原因：

判断存在后进行了put，会覆盖原来的学生信息。


修改为：

```java
if(!students.containsKey(student.getId()))
```

避免重复学号覆盖。


---

## 2. HashMap查询优化

原写法：

```java
if(students.containsKey(id)){

    return students.get(id);

}else{

    return null;

}
```

优化：

```java
return students.get(id);
```

原因：

HashMap的get方法不存在时本身返回null。


---

# 六、今日收获

今天完成了从集合练习到简单后端业务设计的转变。

理解：

- 数据对象和业务逻辑需要分离
- Service负责处理业务
- Map可以作为简单的数据存储
- CRUD是后端开发最基础的业务模型


对应未来Spring Boot结构：

```
Controller

    ↓

Service

    ↓

Repository

    ↓

Database
```

今天学习的StudentService就是未来Service层的基础。

---

# 七、下一步计划

Day05学习：

- Java异常处理
- 参数校验
- 集合综合应用
- 完善学生管理系统

并开始向Spring Boot项目结构过渡。