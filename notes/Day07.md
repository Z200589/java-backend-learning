# Day07｜Java 泛型与学生管理系统模糊查询

**日期：** 2026-10-17  
**学习目标：** Java 后端实习冲刺，基础知识与项目开发并行

## 一、今日学习内容

### 1. 异常处理复习

复习了异常传播、多个 `catch` 的匹配规则以及异常类型的继承关系。

核心知识：

- 一个异常在同一组 `catch` 中，只会进入第一个匹配的分支。
- 多个 `catch` 应先写具体异常，再写通用异常。
- `NullPointerException` 是 `RuntimeException` 的子类，而 `RuntimeException` 是 `Exception` 的子类。
- 如果方法中抛出的异常没有被处理，会沿方法调用链向上传播。

**知识检查结果：10/30。**

其中异常传播题回答正确，但多重 `catch` 的执行规则和继承顺序仍需巩固。

### 2. Java 泛型基础

学习了泛型的作用、泛型类、泛型方法及集合中的类型参数。

核心知识：

- 泛型能够在编译阶段检查类型，提高代码安全性。
- `<T>` 是类型参数，不是普通变量。
- 泛型方法需要在返回值类型前声明类型参数，例如 `public static <T> void printList(...)`。
- `List<Student>` 表示保存 `Student` 类型对象的列表。
- 泛型参数不能直接使用 `int` 等基本类型，需要使用对应包装类型，例如 `Integer`。

### 3. 泛型编程练习

文件：`src/Day07/GenericDemo.java`

独立实现泛型方法：

```java
public static <T> void printList(ArrayList<T> list) {
    for (T t : list) {
        System.out.println(t);
    }
}
```

分别使用 `ArrayList<String>` 和 `ArrayList<Integer>` 进行测试。

IDEA 实际运行结果：

```text
张三
李四
90
95
```

**验收结果：20/20 分，运行成功。**

## 二、项目实践：学生管理系统升级

### 1. 新增姓名模糊查询

文件：`src/Day07/StudentService.java`

新增方法：

```java
public List<Student> findByName(String keyword) {
    if (keyword == null || keyword.isEmpty()) {
        throw new IllegalArgumentException("搜索关键词不能为空");
    }

    List<Student> result = new ArrayList<>();

    for (Student student : students.values()) {
        if (student.getName().contains(keyword)) {
            result.add(student);
        }
    }

    return result;
}
```

主要使用了：

- `Map.values()`：遍历所有学生对象。
- `String.contains()`：匹配姓名中的关键词。
- `List<Student>`：保存多个查询结果。
- `IllegalArgumentException`：拒绝非法参数。

### 2. 编写测试代码

文件：`src/Day07/StudentSearchTest.java`

测试了三个场景：

| 场景 | 输入 | 实际结果 |
|---|---|---|
| 正常模糊查询 | `"张"` | 张三、张小明 |
| 无匹配结果 | `"王"` | 没有找到学生 |
| 空关键词 | `""` | 搜索关键词不能为空 |

IDEA 运行结果：

```text
张三
张小明
没有找到学生
搜索关键词不能为空
```

程序退出代码为 `0`。

**验收结果：30/30 分，三个场景均通过。**

## 三、今日错误与改进

### 错误1：混淆集合与单个对象

错误理解：使用 `student != null` 判断搜索结果是否为空。

正确理解：

- `student != null`：判断单个学生引用。
- `list.isEmpty()`：判断整个结果集合是否为空。

### 错误2：遍历错误的集合

第二次查询使用了 `result2`，但循环错误地遍历了 `result`。

改进：确保查询、判断与遍历使用同一个结果变量。

### 错误3：泛型返回类型不匹配

方法返回类型是 `List<Student>`，不应直接赋给 `ArrayList<Student>` 类型的变量。

改进：优先使用接口类型声明变量。

### 错误4：异常测试不够规范

测试异常时，不应仅依赖打印结果。

改进：如果应该抛出异常但没有抛出，应明确输出测试失败信息。

### 错误5：异常复习仍不熟练

多重 `catch` 的执行与继承顺序题回答错误。

改进：下次学习时结合代码复习异常匹配规则。

## 四、GitHub 提交情况

本地提交已完成：

```text
b11b727 feat: complete Day07 generics and student search
```

GitHub 远程同步尚未确认完成。

已确认 Git 可以通过本地 HTTP 代理成功获取远程信息，但本地与远程存在分叉，目前正在处理合并。

因此，不能将远程推送记录为已完成。

## 五、当前不足与后续计划

- 泛型方法基础练习已经通过，但泛型类、泛型接口还需要进一步编码训练。
- 学生管理系统目前仍使用内存集合，尚未改造为 Spring Boot 数据库接口。
- `findByName()` 尚未处理纯空格关键词及学生姓名为 `null` 的情况。
- 当前测试主要依赖控制台输出，后续需要学习 JUnit 自动化测试。
- 前端 HTML、JavaScript 入门任务尚未完成。
- Qwen 科研今日任务尚未确认完成。

## 六、下次学习目标

1. 复习多重 `catch` 和异常继承关系。
2. 继续 Java 泛型类、泛型接口，随后推进 Java 集合相关内容。
3. 开始 HTML、CSS、JavaScript 基础练习。
4. 将学生管理系统逐步向 Spring Boot + Vue3 全栈项目升级。
5. 完成 Git 合并并确认远程推送结果。

## 七、今日总结

今天完成了 Java 泛型方法的独立编写和运行验证，并在学生管理系统中实现姓名模糊查询。

通过多次代码修改，进一步理解了 `List<Student>`、`Map.values()`、`contains()`、`isEmpty()` 和异常处理的实际使用方式。

后续需要加强异常知识、代码测试的严谨性，并继续以真实项目实践为核心推进 Java 后端实习准备。