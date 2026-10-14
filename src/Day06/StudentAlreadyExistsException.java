package Day06;

public class StudentAlreadyExistsException extends RuntimeException{

    // 请你自己完成
    /*类名为 StudentAlreadyExistsException。

    继承 RuntimeException。

    定义一个接收 String message 参数的构造方法。

    在构造方法中使用 super(message)，将异常信息传递给父类。*/

    public StudentAlreadyExistsException(String message){
        super(message);
    }


}