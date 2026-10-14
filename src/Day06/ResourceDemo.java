package Day06;

import java.io.FileReader;
import java.io.IOException;

public class ResourceDemo {
    public static void main(String[] args) {

        // TODO: 使用 try-with-resources 打开 test.txt

        // TODO: 使用 while 循环逐个读取字符

        // TODO: 使用 catch 捕获 IOException


        try(FileReader fr = new FileReader("test.txt")){
            int ch;
            while((ch = fr.read()) != -1){
                System.out.print((char)ch);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}