package Day05;

public class ExceptionDemo {
    public static void main(String[] args) {
        int a = 20;
        int b = 0;

        // TODO 1：使用 try 包裹除法运算

        try{
            int c = a / b;
        }catch(ArithmeticException e){
            System.out.println(("计算失败：除数不能为0"));
        }
        System.out.println("程序执行结束");

        // TODO 2：使用 catch 捕获 ArithmeticException

        // TODO 3：异常发生时打印指定错误信息

        // TODO 4：最后打印“程序执行结束”
    }
}