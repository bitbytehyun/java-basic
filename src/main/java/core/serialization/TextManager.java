package core.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class TextManager {
    public void write() throws IOException {
        String message = "Hello, World!";
        byte[] bytes = message.getBytes(StandardCharsets.UTF_8);

        FileOutputStream fos = new FileOutputStream("message.txt");
        fos.write(bytes);
        fos.close();

        System.out.println("파일 저장 완료");
    }
}
