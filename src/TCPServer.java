import java.net.*;
import java.io.*;

public class TCPServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(6666);
        Socket socket = null;
        while ((socket = serverSocket.accept()) != null) {
            OutputStream out = socket.getOutputStream();
            // 对方端口和IP
            int senderPort = socket.getPort();
            String senderIp = socket.getInetAddress().getHostAddress();
            int localPort=socket.getLocalPort();
            String localIp=socket.getLocalAddress().getHostAddress();
            System.out.println(String.format("客户端ip:%s ,端口号:%s", senderIp, senderPort));
            System.out.println(String.format("服务器ip:%s ,端口号:%s", localIp, localPort));
            out.write(String.format("Welcome,%s:%s !", senderIp, senderPort).getBytes());
            out.flush();
            out.close();
            socket.close();
        }
    }

}
