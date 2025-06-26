package core.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SimpleClient {
    public static void main(String[] args) throws IOException {
        // 클라이언트 생성하여 서버에 연결
        SocketChannel client = SocketChannel.open(new InetSocketAddress("localhost", 5000));
        System.out.println("서버에 연결됨");

        // 매세지 준비
        String message = "Hello, Server!";
        ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());

        // 서버에 데이터 전송
        client.write(buffer);

        // 닫기
        client.close();
        System.out.println("메세지 전송 후 종료");
    }
}
