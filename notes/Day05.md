# Day05 Java 异常处理

## 一、今日学习内容

- Java 异常的基本概念
- `try-catch` 捕获异常
- `throw` 主动抛出异常
- `throws` 声明可能抛出的异常
- `IllegalArgumentException` 的使用
- Service 层业务异常处理

## 二、核心知识

### 1. try-catch

`try` 中发生异常后，如果存在匹配的 `catch`，程序会进入对应的异常处理代码块。捕获并处理完成后，可以继续执行后续代码。

### 2. throw 和 throws

- `throw`：主动抛出异常对象。
- `throws`：在方法声明中说明可能抛出的异常。
- `IllegalArgumentException` 属于非受检异常，不强制要求声明 `throws`。

### 3. Service 层异常处理

业务方法发现非法参数时，可以直接抛出异常，由调用方统一处理。

不要在业务方法内部捕获异常后继续执行可能修改数据的操作。

## 三、今日编程练习

1. ExceptionDemo：使用 `try-catch` 处理除零异常。
2. AgeValidator：使用 `throw` 校验年龄范围。
3. StudentService：处理空学生对象和重复学号。
4. Test：测试正常添加、异常捕获和重复学号的数据保护。

## 四、今天遇到的问题

**问题1：异常类型选择错误**

最初使用 `IllegalAccessException` 表示年龄参数不合法。

修正：使用 `IllegalArgumentException`。

**问题2：Service 内部捕获异常**

最初在 `addStudent()` 中捕获异常后继续执行，可能造成空指针或覆盖旧数据。

修正：在 Service 层直接抛出异常，由调用方捕获。

**问题3：实例方法调用错误**

最初通过 `StudentService.addStudent()` 调用非静态方法。

修正：创建 `StudentService` 对象后，通过 `service.addStudent()` 调用。

## 五、测试验收

- [ ] 正常添加学生成功
- [ ] 添加 null 时抛出预期异常
- [ ] 重复学号时抛出预期异常
- [ ] 原学生数据未被覆盖
- [ ] 程序正常输出“测试结束”

## 六、今日总结

通过 Day5 的学习，我理解了异常不仅用于处理运行错误，也可以表达业务规则不满足的情况。

在后端开发中，需要明确异常由哪一层抛出、哪一层处理，避免异常被错误吞掉后继续修改数据。