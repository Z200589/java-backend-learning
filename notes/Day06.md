# Day06 Java异常处理

## 一、今日学习内容

1. 自定义异常：通过继承 `RuntimeException` 创建业务异常。
2. `throw`：主动抛出异常；`throws`：在方法声明中声明可能抛出的异常。
3. `try-catch-finally`：处理异常，并在 `finally` 中执行通常需要执行的收尾逻辑。
4. `try-with-resources`：自动关闭实现了 `AutoCloseable` 的资源。
5. 异常传播：异常未被当前方法处理时，会沿调用链向上传播。
6. 多重 `catch`：只执行第一个匹配的 `catch`。

## 二、今日实践

- 创建 `StudentAlreadyExistsException` 自定义异常。
- 修改 `StudentService`，检测重复学号并抛出异常。
- 编写 `FinallyDemo`，验证异常处理顺序。
- 编写 `ResourceDemo`，通过 `FileReader` 读取文本文件。
- 在 IDEA 中验证程序运行。

## 三、容易出错的知识点

- `IOException` 是受检异常；`RuntimeException` 及其子类是非受检异常。
- `finally` 通常会执行，但不能说绝对执行。
- 同一个异常不会依次执行多个 `catch`。
- `FileReader.read()` 返回 `int`，读到文件末尾时返回 `-1`。
- 文件相对路径取决于程序运行时的工作目录。

## 四、明日复习

- `finally` 与 `return` 的执行顺序。
- 受检异常与非受检异常的区别。
- 异常传播与多重 `catch` 的匹配规则。

## 五、下一阶段

Day07：Java 泛型基础 + 前端 HTML/CSS/JavaScript 摸底。