import java.io.*;
import java.net.*;

public class UDPClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket datagramSocket = new DatagramSocket(6667);
        byte[] sendBytes = "Hello !".getBytes();
        DatagramPacket sendP = new DatagramPacket(sendBytes, sendBytes.length);
        sendP.setSocketAddress(new InetSocketAddress("0.0.0.0", 6666));
        datagramSocket.send(sendP);
        byte[] recvBytes = new byte[1024];
        DatagramPacket recvP = new DatagramPacket(recvBytes, recvBytes.length);
        datagramSocket.receive(recvP);
        String recvS = new String(recvBytes, 0, recvP.getLength());
        System.out.println("服务器回应 :"+recvS);


    }
}
