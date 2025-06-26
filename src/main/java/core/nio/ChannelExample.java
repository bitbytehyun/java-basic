package core.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelExample {
    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile("example.txt", "r");
        FileChannel channel = file.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(10);
        int bytesRead = channel.read(buffer); // bytesRead 바이트만큼 buffer로 읽어들였다!

        while (bytesRead != -1) {
            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.print((char) (buffer.get()));
            }
            buffer.clear();
            bytesRead = channel.read(buffer); // 버퍼 용량이 꽉 찼을 경우, 다시 버퍼에 채우기
        }

        channel.close();
        file.close();
    }

}
