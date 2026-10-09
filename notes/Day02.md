# Day 02｜Java 集合进阶：HashMap 与 HashSet

> 学习日期：2026-10-09  
> 学习目标：Java 后端实习  
> 学习状态：核心知识已完成，学生管理系统 V2 留待下一次

## 一、今日学习内容

今天主要学习了 Java 集合框架中的 `HashMap` 和 `HashSet`，并结合学生管理系统完成了多道编程练习。

已完成：

- [x] HashMap 基础操作：put、get、remove、size
- [x] HashMap 判断 Key 是否存在
- [x] HashMap 使用 entrySet 遍历
- [x] HashMap 学生成绩统计
- [x] HashMap 基础知识验收
- [x] HashSet 基础操作与去重
- [x] HashSet 重复登录检测
- [x] equals() 与 hashCode() 原理
- [x] Student 对象 HashSet 去重
- [ ] 学生管理系统 V2（HashMap 版本）

---

## 二、HashMap 知识总结

### 1. HashMap 是什么？

HashMap 是 Java 中用于存储键值对（Key-Value）的集合。

特点：

1. 每个 Key 都是唯一的。
2. Value 可以重复。
3. 使用 Key 查找对应的 Value。
4. 不保证遍历顺序。
5. 相同 Key 再次执行 put() 会覆盖原来的 Value。

### 2. 常用方法

| 方法 | 作用 |
|---|---|
| put(key, value) | 添加或更新数据 |
| get(key) | 根据 Key 获取 Value |
| remove(key) | 删除数据 |
| containsKey(key) | 判断 Key 是否存在 |
| size() | 获取键值对数量 |
| keySet() | 获取所有 Key |
| values() | 获取所有 Value |
| entrySet() | 获取所有键值对 |

### 3. 基础代码

```java
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, Integer> scores = new HashMap<>();

        scores.put(1001, 90);
        scores.put(1002, 75);
        scores.put(1003, 58);

        System.out.println(scores.get(1002));

        scores.put(1001, 95);

        scores.remove(1003);

        System.out.println(scores.size());
    }
}
```

### 4. 判断 Key 是否重复

```java
if (scores.containsKey(1001)) {
    System.out.println("学号已存在");
} else {
    scores.put(1001, 90);
}
```

注意：`get(key) == null` 不一定表示 Key 不存在，因为 HashMap 允许 Value 为 null。

判断 Key 是否存在，应优先使用 `containsKey()`。

### 5. 使用 entrySet 遍历

```java
for (HashMap.Entry<Integer, Integer> entry : scores.entrySet()) {
    System.out.println("学号：" + entry.getKey());
    System.out.println("成绩：" + entry.getValue());
}
```

- `entry.getKey()`：获取当前键值对的 Key。
- `entry.getValue()`：获取当前键值对的 Value。

### 6. 今日错误复盘

在成绩统计练习中，最初写过类似代码：

```java
scores.get(entry.getValue());
```

错误原因：

`entry.getValue()` 获取的是成绩，而 `scores.get()` 需要传入学号作为 Key。

如果不存在对应的 Key，`get()` 返回 null；如果再自动拆箱为 int，就可能发生 NullPointerException。

正确写法：

```java
int score = entry.getValue();
```

完整统计示例：

```java
int passed = 0;
int sum = 0;

for (HashMap.Entry<Integer, Integer> entry : scores.entrySet()) {
    int score = entry.getValue();

    if (score >= 60) {
        passed++;
    }

    sum += score;
}

double average = (double) sum / scores.size();
```

注意：

- 人数使用 int 类型。
- 平均分使用 double 类型。
- 整数相除时需要进行类型转换。
- 实际项目中还需要处理集合为空的情况，避免除以零。

---

## 三、HashSet 知识总结

### 1. HashSet 是什么？

HashSet 是不允许重复元素的集合。

特点：

1. 不允许重复元素。
2. 不保证遍历顺序。
3. 不支持通过索引访问元素。
4. 底层使用 HashMap 实现。

### 2. 常用方法

| 方法 | 作用 |
|---|---|
| add(element) | 添加元素 |
| remove(element) | 删除元素 |
| contains(element) | 判断元素是否存在 |
| size() | 获取元素数量 |
| isEmpty() | 判断集合是否为空 |
| clear() | 清空集合 |

### 3. 用户访问去重

```java
HashSet<Integer> users = new HashSet<>();

users.add(1001);
users.add(1002);
users.add(1003);
users.add(1001);
users.add(1004);
users.add(1002);
users.add(1005);

System.out.println("不同用户数量：" + users.size());

System.out.println(users.contains(1003));

users.remove(1004);

for (Integer user : users) {
    System.out.println(user);
}
```

虽然添加了七次，但只有五个不同的用户。

删除 1004 后，集合中剩余四个用户。

### 4. add() 的返回值

`HashSet.add()` 返回 boolean。

- true：元素原来不存在，添加成功。
- false：元素已经存在，没有添加。

```java
HashSet<String> names = new HashSet<>();

System.out.println(names.add("Tom"));   // true
System.out.println(names.add("Jerry")); // true
System.out.println(names.add("Tom"));   // false

System.out.println(names.size());       // 2
```

### 5. 重复登录检测

今天第一次实现时，采用了 contains() 加 add() 的方式，逻辑正确，但还可以简化。

优化后的代码：

```java
int[] logins = {
    1001, 1002, 1003, 1001,
    1004, 1002, 1005, 1003
};

HashSet<Integer> users = new HashSet<>();

for (int userId : logins) {
    if (!users.add(userId)) {
        System.out.println("用户 " + userId + " 重复登录");
    }
}

System.out.println("不同用户总数：" + users.size());
```

核心收获：

可以直接利用 add() 的返回值判断是否出现重复元素，不需要先调用 contains()。

---

## 四、equals() 与 hashCode()

### 1. 为什么两个属性相同的对象不一定相等？

```java
Student s1 = new Student(1001, "张三");
Student s2 = new Student(1001, "张三");
```

即使两个对象属性相同，它们仍然是通过两次 new 创建的不同对象。

如果 Student 没有重写 equals()：

```java
System.out.println(s1 == s2);      // false
System.out.println(s1.equals(s2)); // false
```

### 2. equals() 的作用

equals() 用于判断两个对象在业务逻辑上是否相等。

在学生管理系统中，规定：

只要学号相同，就认为是同一名学生。

```java
@Override
public boolean equals(Object obj) {
    if (this == obj) {
        return true;
    }

    if (!(obj instanceof Student)) {
        return false;
    }

    Student other = (Student) obj;

    return this.id == other.id;
}
```

### 3. hashCode() 的作用

hashCode() 返回对象的哈希值，HashSet 会利用它帮助定位和比较元素。

```java
@Override
public int hashCode() {
    return Objects.hash(id);
}
```

### 4. equals() 与 hashCode() 的关系

必须记住：

**如果两个对象 equals() 返回 true，那么它们的 hashCode() 必须相同。**

但是：

**两个对象的 hashCode() 相同，不代表 equals() 一定返回 true。**

不同对象可能发生哈希冲突。

### 5. 为什么通常要同时重写？

如果只重写 equals()，不重写 hashCode()，HashSet 可能无法按照预期去重。

因此，当需要根据对象属性判断相等时，通常应同时重写 equals() 和 hashCode()。

还要注意：不要在对象已经存入 HashSet 后随意修改参与哈希计算的字段。

---

## 五、Student 对象去重实战

### 1. Student.java

```java
package Day02;

import java.util.Objects;

public class Student {

    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Student)) {
            return false;
        }

        Student other = (Student) obj;
        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
```

### 2. Main5.java

```java
package Day02;

import java.util.HashSet;

public class Main5 {
    public static void main(String[] args) {

        HashSet<Student> students = new HashSet<>();

        students.add(new Student(1001, "张三"));
        students.add(new Student(1002, "李四"));
        students.add(new Student(1001, "张三"));
        students.add(new Student(1003, "王五"));
        students.add(new Student(1002, "赵六"));

        System.out.println(
            "去重后的学生数量为：" + students.size()
        );

        for (Student stu : students) {
            System.out.println(
                stu.getId() + " : " + stu.getName()
            );
        }
    }
}
```

预期结果：

```text
去重后的学生数量为：3
1001 : 张三
1002 : 李四
1003 : 王五
```

注意：HashSet 不保证遍历顺序。

### 3. 为什么赵六没有覆盖李四？

```java
students.add(new Student(1002, "李四"));
students.add(new Student(1002, "赵六"));
```

由于两个学生的学号相同，equals() 判断相等。

因此，第二次添加失败，原来的李四仍然保留。

如果业务需要根据学号更新学生信息，HashMap<Integer, Student> 通常更合适。

---

## 六、今日错误与改进

| 问题 | 原因 | 改进 |
|---|---|---|
| HashMap 成绩统计出现空指针风险 | 混淆 getKey 和 getValue | 使用 entry.getValue() 获取成绩 |
| 使用 double 统计人数 | 数据类型选择不合理 | 人数使用 int |
| 重复登录检测未利用 add() 返回值 | 对集合方法不够熟悉 | 使用 if (!set.add(x)) |
| Student 方法缺少 @Override | 未形成重写规范 | 重写父类方法时添加 @Override |
| Main5 出现重复类定义 | 复制粘贴时没有整理结构 | 检查 package、import、class 和大括号 |
| Main5 缺少 package Day02 | 包声明不一致 | 确保 Student 和 Main5 位于相同包 |
| 输出中出现多余的加号 | 混淆字符串内容与拼接符 | 区分 " + " 和 + |

---

## 七、HashMap 与 HashSet 对比

| 对比项 | HashMap | HashSet |
|---|---|---|
| 存储内容 | Key-Value 键值对 | 单个元素 |
| 唯一性 | Key 唯一 | 元素唯一 |
| 添加方法 | put() | add() |
| 查询方法 | get()、containsKey() | contains() |
| 重复处理 | 相同 Key 覆盖 Value | 重复元素不添加 |
| 遍历 | entrySet()、keySet() | 增强 for |
| 典型用途 | 学生信息管理 | 用户去重 |

---

## 八、今日学习成果

### 已掌握

1. HashMap 的基本 CRUD 操作。
2. 使用 containsKey() 判断 Key 是否存在。
3. 使用 entrySet() 遍历键值对。
4. 使用 HashMap 进行成绩统计。
5. HashSet 的自动去重机制。
6. 利用 add() 返回值判断重复数据。
7. equals() 与 hashCode() 的基本契约。
8. 使用 HashSet 对自定义 Student 对象去重。

### 仍需加强

1. 独立编写代码时检查文件结构。
2. 熟练使用方法返回值简化代码。
3. 理解 HashMap 与 HashSet 在实际业务中的选择。
4. 在实际项目中熟练使用对象集合。

---

## 九、下一次学习计划

### 学生管理系统 V2：HashMap 版本

计划使用：

```java
HashMap<Integer, Student> students = new HashMap<>();
```

逐步实现：

- [ ] 第一关：新增学生并检查重复学号
- [ ] 第二关：根据学号查询学生
- [ ] 第三关：修改学生信息
- [ ] 第四关：根据学号删除学生
- [ ] 第五关：遍历输出全部学生
- [ ] 第六关：整合为完整的控制台学生管理系统

下一次从第一关开始，继续采用自己编写代码、提交批改、修正错误的学习方式。

---

## 十、今日复盘

今天最大的收获不是记住了多少集合方法，而是开始理解 Java 集合背后的设计逻辑。

HashMap 适合根据唯一标识查找和管理对象。

HashSet 适合判断元素是否存在，以及对数据进行去重。

对于自定义对象，HashSet 的去重行为取决于 equals() 和 hashCode() 的正确实现。

今天已经能够独立完成 Student 对象去重实战，但代码组织和细节检查还需要加强。

**今日总结：核心知识已完成，下一次继续学生管理系统 V2。**