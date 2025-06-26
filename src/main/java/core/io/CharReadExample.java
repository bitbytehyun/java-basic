package core.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CharReadExample {
    public static void main(String[] args) {
        try (BufferedReader bf = new BufferedReader(new FileReader("example.txt"))) {
            String line;
            while ((line = bf.readLine()) != null) { // 한 줄을 문자열로 통채로 읽음
                System.out.println(line);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
