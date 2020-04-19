import java.net.*;
import java.io.*;


public class TCPClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("0.0.0.0", 6666));
        String localIp = socket.getInetAddress().getHostAddress();
        int localPort = socket.getLocalPort();
        System.out.println(String.format("本地ip:%s ,端口号:%s", localIp, localPort));
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line = reader.readLine();
        System.out.println(line);
        socket.close();
    }
}
