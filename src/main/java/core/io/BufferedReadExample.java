package core.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferedReadExample {
    public static void main(String[] args) {

        // byte[] buf 로 캐싱을 하기 떄문에, 내부 os 호출이 FileInputStream보다 적다
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("example.txt"))) {
            int data;
            while ((data = bis.read()) != -1) {
                char character = (char) data;
                System.out.print(character);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
