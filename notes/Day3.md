Day2-3 Java集合进阶学习总结
日期：2026-10-12
学习目标
掌握 Java 常用集合框架，为后续 Spring Boot 后端开发打基础。
一、HashMap
1. HashMap概念
   HashMap 存储的是 Key-Value 键值对。
   结构：
   Key ---> Value
   例如：
   学号 ---> 学生对象
   1001 ---> Student
   Java定义：
   Map<Integer, Student> students = new HashMap<>();
2. Map接口
   推荐写法：
   Map<Integer,String> map = new HashMap<>();
   原因：
   面向接口编程。
   Map 是接口，HashMap 是实现类。
3. HashMap常用方法
   添加：
   map.put(key,value);
   查询：
   map.get(key);
   修改：
   重新 put，Key相同会覆盖Value。
   删除：
   map.remove(key);
   二、HashMap存储对象
   实际开发：
   Map<Integer,Student>
   表示：
   学号 ---> Student对象
   应用：
- 用户ID查询用户
- 商品ID查询商品
- 订单ID查询订单
  三、Map遍历
  推荐：
  for(Map.Entry<Integer,Student> entry : map.entrySet()){

}
Entry同时包含Key和Value。
获取：
entry.getKey();

entry.getValue();
四、HashSet
HashSet特点：
- 无序
- 不允许重复
  示例：
  Set<String> names = new HashSet<>();

names.add("张三");
names.add("李四");
names.add("张三");
重复数据不会添加。
五、HashSet去重原理
HashSet底层使用HashMap。
类似：
HashSet
↓
HashMap
key ---> value
通过HashMap的Key唯一实现去重。
六、equals和hashCode
equals
Java默认比较对象地址。
如果希望比较对象内容，需要重写equals。
Student中根据学号判断是否相同。
hashCode
HashSet判断对象时：
1. hashCode()
2. equals()
   规则：
   如果equals返回true，则hashCode必须相同。
   所以：
   equals和hashCode必须一起重写。
   七、集合综合项目 StudentManager V3
   使用：
   List<Student>

Map<Integer,Student>

Set<Student>
实现：
- 添加学生
- 根据id查询学生
- 修改学生成绩
- 删除学生
- 学生去重
  八、List、Set、Map区别
  List
  特点：
- 有序
- 可重复
- 可以通过下标访问
  删除：
  list.remove(student);
  根据对象删除。
  Set
  特点：
- 不允许重复
  删除：
  set.remove(student);
  依靠hashCode和equals判断对象。
  Map
  特点：
- Key-Value结构
  删除：
  map.remove(key);
  根据Key删除。
  九、今日总结
  掌握：
- ArrayList
- LinkedList
- HashMap
- Map接口
- HashMap存对象
- Map遍历
- HashSet
- equals()
- hashCode()
- 集合综合设计
  这些知识会应用于：
- Spring Boot Controller
- Service层设计
- 用户管理系统
- 数据缓存
- 数据查询
  下一步学习
  Day4：Java面向对象强化
  学习：
- 封装
- this关键字
- 构造方法
- 继承
- 多态
- 接口
  为 Spring Boot 学习做准备。