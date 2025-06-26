package core.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class SimpleServerSocketChannelExample {
    public static void main(String[] args) throws IOException {
        // 서버 소켓 채널 생성
        ServerSocketChannel serverChannel = ServerSocketChannel.open();

        // 주소 바인딩
        serverChannel.bind(new InetSocketAddress(5000));
        System.out.println("Server is listening on port 5000...");

        // 클라이언트 연결 수락
//        serverChannel.configureBlocking(false); // 블로킹 제어
        SocketChannel clientChannel = serverChannel.accept(); // 블로킹
        System.out.println("Client connected: " + clientChannel.getRemoteAddress());

        // 데이터 읽기
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int bytesRead = clientChannel.read(buffer);
        buffer.flip();
        while (buffer.hasRemaining()) {
            System.out.print((char) (buffer.get()));
        }

        // 닫기
        clientChannel.close();
        serverChannel.close();
        System.out.println("\nServer closed");
    }
}
