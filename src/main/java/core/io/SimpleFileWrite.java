package core.io;

import java.io.FileOutputStream;
import java.io.IOException;

public class SimpleFileWrite {
    public static void main(String[] args) {
        String text = "Hello, Java IO!";
        try (FileOutputStream fos = new FileOutputStream("output.txt")) {
            byte[] bytes = text.getBytes();
            fos.write(bytes);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
