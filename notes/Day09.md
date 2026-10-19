# Day 09：Spring Boot 分层开发与前后端联调

## 一、今日目标

- 掌握 HashMap 的 getOrDefault() 计数方式
- 理解 Optional.ofNullable() 的使用
- 掌握 @PathVariable 路径参数
- 学习 @Service 和构造器注入
- 完成学生详情查询与 HTTP 404 处理
- 使用 fetch() 实现前后端查询

## 二、Java 基础

### 1. HashMap 计数

```java
counts.put(word, counts.getOrDefault(word, 0) + 1);
```

getOrDefault() 在键不存在时返回默认值，不会自行更新 Map；put() 才会保存新的计数。

### 2. Optional 查询

```java
return Optional.ofNullable(students.get(id));
```

用于将可能为 null 的查询结果封装为 Optional。

## 三、Spring Boot 分层

- Controller：接收 HTTP 请求并返回响应。
- Service：处理业务查询逻辑。
- 当前数据存储：ArrayList<StudentInfo>，尚未接入数据库。

使用构造器注入：

```java
private final StudentService studentService;

public StudentController(StudentService studentService) {
    this.studentService = studentService;
}
```

## 四、接口设计

| 方法 | 路径 | 功能 |
|---|---|---|
| GET | /students | 查询全部学生 |
| GET | /students/{id} | 按学号查询学生 |

查询成功返回 200；学生不存在时返回 404。

## 五、前端联调

- 使用 getElementById() 获取页面元素。
- 使用 addEventListener() 监听按钮点击。
- 使用 fetch() 请求后端接口。
- 使用 response.ok 判断 HTTP 请求是否成功。
- 使用 response.json() 解析 JSON 数据。
- 使用 textContent 展示查询结果。
- 对空输入和查询失败进行提示。

## 六、测试结果

- 学号 1001：通过
- 学号 1002：通过
- 学号 9999：通过，显示学生不存在
- 空输入：通过，显示请输入学号

## 七、待改进

- 使用 MySQL 保存学生数据。
- 增加 Repository 数据访问层。
- 使用统一异常处理。
- 增加自动化接口测试。
- 改善前端列表加载失败时的错误提示。

## 八、今日复盘

记录自己遇到的错误、解决方法，以及尚未完全理解的知识点。
