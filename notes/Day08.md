# Day8 学习总结：Java 集合、Spring Boot REST API 与前后端联调

**日期：** 2026-10-18  
**学习主线：** Java 后端实习  
**今日重点：** 集合排序、REST API、前后端联调、HashMap 频次统计

---

## 一、Java 集合排序

### 1. 学习内容

- 使用 `List<Student>` 保存学生对象。
- 使用 Lambda 表达式简化比较器的编写。
- 使用 `students.sort()` 对学生集合排序。
- 通过 `getAge()` 获取学生年龄，完成年龄升序排序。

### 2. 核心代码

```java
students.sort((a, b) -> {
    if (a.getAge() > b.getAge()) {
        return 1;
    } else if (a.getAge() == b.getAge()) {
        return 0;
    } else {
        return -1;
    }
});
```

### 3. 知识总结

比较器返回值的含义：

- 返回负数：`a` 排在 `b` 前面。
- 返回零：两者在当前比较规则下相等。
- 返回正数：`a` 排在 `b` 后面。

使用 Lambda 表达式可以简化集合排序代码。

### 4. 验收情况

已运行排序程序，并查看排序输出。

---

## 二、Spring Boot REST API

### 1. 项目环境

- 项目名称：`student-api`
- Spring Boot 版本：4.1.1
- Java 版本：17
- 构建工具：Maven
- Web 依赖：`spring-boot-starter-webmvc`

项目创建过程中曾遇到 Maven 加载失败、Spring 注解无法解析等问题。切换为 Maven 包装器后，Maven 加载成功，相关注解不再报错。

### 2. 创建 StudentInfo 实体类

使用 `StudentInfo` 表示一名学生，包含以下字段：

```java
private int id;
private String name;
private int age;
```

完成的内容：

- 声明三个 `private` 字段。
- 编写接收学号、姓名、年龄的构造方法。
- 编写 `getId()`、`getName()`、`getAge()`。
- 编写对应的 setter 方法。

### 3. 创建学生查询接口

使用 `@RestController` 声明控制器，使用 `@GetMapping("/students")` 映射查询接口。

接口返回类型：

```java
List<StudentInfo>
```

控制器中创建学生集合，并添加两名学生：

| 学号 | 姓名 | 年龄 |
|---|---|---:|
| 1001 | 张三 | 20 |
| 1002 | 李四 | 21 |

### 4. 验收结果

已在 IDEA 中启动 Spring Boot 项目，并通过浏览器访问：

`http://localhost:8080/students`

接口成功返回包含两名学生信息的 JSON 数据。

### 5. 知识总结

- `@RestController`：声明 REST 控制器。
- `@GetMapping`：将 HTTP GET 请求映射到指定方法。
- `List<StudentInfo>`：表示学生对象集合。
- Spring Boot 能够将控制器返回的对象集合转换为 JSON 响应。

---

## 三、前端与后端联调

### 1. 创建 HTML 页面

新建 `index.html`，页面包含学生信息表格。

表格有三个表头：

- 学号
- 姓名
- 年龄

使用 `tbody` 的 `id="studentsBody"` 定位需要动态填充的区域。

### 2. 使用 fetch 请求后端

前端使用以下代码请求接口：

```javascript
fetch('/students')
    .then(response => {
        return response.json();
    })
    .then(data => {
        console.log(data);
    });
```

知识点：

- `fetch()`：发送网络请求。
- `response.json()`：解析响应体中的 JSON。
- `data`：接收解析后的学生数组。

### 3. 动态生成 HTML 表格

使用 `data.forEach()` 遍历学生数组。

主要步骤：

1. 使用 `document.getElementById()` 获取表格主体。
2. 使用 `document.createElement("tr")` 创建表格行。
3. 使用 `document.createElement("td")` 创建单元格。
4. 使用 `textContent` 设置学号、姓名、年龄。
5. 使用 `appendChild()` 将单元格添加到表格行。
6. 将整行添加到 `studentsBody`。

### 4. 验收结果

已确认：

- 浏览器成功获取后端 JSON 数据。
- 学生数据成功显示在 HTML 表格中。
- 表格中的学号、姓名、年龄与后端数据一致。

这完成了从 Spring Boot 接口到 HTML 页面展示的基本前后端联调流程。

---

## 四、HashMap 频次统计

### 1. 整数频次统计

输入数组：

```java
int[] nums = {1, 2, 4, 2, 4, 4};
```

使用 `HashMap<Integer, Integer>` 统计数字出现次数。

实际运行结果：

```text
{1=1, 2=2, 4=3}
```

### 2. 字符串频次统计

输入数组：

```java
String[] words = {
    "java", "python", "java",
    "go", "python", "java"
};
```

使用 `HashMap<String, Integer>` 统计单词出现次数。

实际运行结果：

```text
{python=2, java=3, go=1}
```

`HashMap` 不保证键的遍历顺序，因此输出顺序可能不同，不影响统计正确性。

### 3. 核心统计逻辑

```java
for (String word : words) {
    if (map.containsKey(word)) {
        map.put(word, map.get(word) + 1);
    } else {
        map.put(word, 1);
    }
}
```

理解：

- `containsKey()`：判断键是否存在。
- `get()`：获取已有次数。
- `put()`：新增键值对或更新已有次数。
- 第一次出现的元素，计数设为 `1`。

### 4. 方法封装

将统计逻辑封装为：

```java
public static Map<String, Integer> countWords(String[] words)
```

方法内部使用：

```java
Map<String, Integer> map = new HashMap<>();
```

统计结束后返回：

```java
return map;
```

已完成 IDEA 运行验收，程序正常结束，退出代码为 `0`。

### 5. 知识总结

- 使用泛型明确集合中键和值的类型。
- 使用增强 `for` 循环遍历数组。
- 使用 `if-else` 处理首次出现和重复出现的元素。
- 通过方法封装实现逻辑复用。
- 面向接口编程：使用 `Map` 声明变量或返回类型，使用 `HashMap` 创建对象。

---

## 五、今日问题与解决方法

### 问题 1：Spring 注解无法解析

**原因：** Maven 加载出现异常。

**解决：** 切换为 Maven 包装器，等待依赖重新加载，之后注解恢复正常。

### 问题 2：无法正确返回学生列表

**原因：** 方法返回类型与实际返回值不一致，且曾尝试将集合转成字符串。

**解决：** 将方法返回类型改为 `List<StudentInfo>`，直接返回学生集合。

### 问题 3：学生对象没有显示在集合中

**原因：** 创建学生对象不等于将对象添加到集合。

**解决：** 使用 `students.add()` 将学生对象添加到集合。

### 问题 4：前端无法正确获取 JSON

**原因：** 请求路径和 `response.json()` 调用方式曾经写错。

**解决：** 使用正确的 `/students` 路径，并调用 `response.json()`。

### 问题 5：HashMap 频次统计没有处理新元素

**原因：** 最初的实现只处理已经存在的键。

**解决：** 在 `else` 分支中将首次出现的元素计数初始化为 `1`。

---

## 六、今日学习成果

今日已确认完成：

- [x] Java 集合排序练习及运行检查
- [x] 创建 Spring Boot 学生查询接口
- [x] 创建 StudentInfo 实体类
- [x] GET `/students` 返回学生 JSON
- [x] 前端使用 fetch 获取数据
- [x] 动态生成学生信息表格
- [x] HashMap 整数频次统计
- [x] HashMap 字符串频次统计
- [x] countWords() 方法封装
- [x] 使用 Map 接口作为返回类型
- [x] IDEA 运行验收通过

## 七、后续待办

以下事项尚未在本次对话中确认完成：

- [ ] 将 `notes/Day08.md` 保存到本地 Git 仓库。
- [ ] 检查 Git 状态，提交 Day8 学习总结。
- [ ] 推送到 GitHub，并确认远端同步成功。
- [ ] 完成操作系统课程的自主学习任务。
- [ ] 后续完善学生管理 API，例如增加学生、查询单个学生等功能。

---

**Day8 总结：** 今天完成了 Java 集合排序、HashMap 频次统计、方法封装，以及 Spring Boot REST API 与 HTML 页面的前后端联调。下一阶段继续围绕 Java 后端实习目标推进，逐步完善学生管理项目，并保持每日代码提交与学习复盘。