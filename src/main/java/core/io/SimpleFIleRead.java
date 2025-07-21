package core.io;

import java.io.FileInputStream;
import java.io.IOException;

public class SimpleFIleRead {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("example.txt")) {
            int data;
            while ((data = fis.read()) != -1) { // 1바이트씩 읽기
                char character = (char) data;
                System.out.print(character);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
