package Day06;

public class FinallyDemo {
    public static void main(String[] args) {

        // 在这里独立完成
        /*在 main() 中使用 try-catch-finally。
        在 try 中先打印 "开始计算"。
        在 try 中执行 int result = 10 / 0;。
        使用 catch 捕获 ArithmeticException，打印 "发生算术异常"。
        在 finally 中打印 "finally执行"。
        在整个异常处理结构之后打印 "程序结束"。*/

        try{
            System.out.println("开始计算");
            int result = 10 / 0;
        }catch (ArithmeticException e){
            System.out.println("发生算术异常");
        }finally {
            System.out.println("finally执行");
        }

        System.out.println("程序结束");

    }
}