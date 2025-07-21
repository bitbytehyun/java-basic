package core.io;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class CharWriteExample {
    public static void main(String[] args) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {
            bw.write("Hello, Java IO!");
            bw.write("BufferedWriter를 사용해서 한 줄씩 씁니다.");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
