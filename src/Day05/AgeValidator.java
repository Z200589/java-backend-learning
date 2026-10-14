package Day05;

public class AgeValidator {

    public static void checkAge(int age) throws IllegalArgumentException {

        // TODO 1：判断 age < 0，主动抛出异常

        if(age < 0) {
            throw new IllegalArgumentException ("年龄不能为负数");
        }

        // TODO 2：判断 age > 150，主动抛出异常

        if(age > 150) {
            throw new IllegalArgumentException("年龄不能超过150岁");
        }

        // TODO 3：合法年龄打印“年龄合法”

        System.out.println("年龄合法");

    }

    public static void main(String[] args) {

        // TODO 4：使用 try-catch 调用 checkAge(-5)

        try{
            checkAge(-5);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        // TODO 5：在 catch 中打印 e.getMessage()

        System.out.println("程序执行结束");
    }
}