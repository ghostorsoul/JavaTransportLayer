import java.net.*;
import java.io.*;

public class TCPServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(6666);
        Socket socket = null;
        while ((socket = serverSocket.accept()) != null) {
            OutputStream out = socket.getOutputStream();
            // 对方端口和IP
            int port = socket.getPort();
            String ip = socket.getInetAddress().getHostAddress();
            out.write(String.format("Welcome,%s:%s !", ip, port).getBytes());
            out.flush();
            out.close();
            socket.close();
        }
    }

}
