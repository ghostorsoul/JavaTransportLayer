import java.io.*;
import java.net.*;

public class UDPServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket datagramSocket = new DatagramSocket(6666);
        while (true) {
            // 接受
            byte[] recvBytes = new byte[1024];
            DatagramPacket pRecv = new DatagramPacket(recvBytes, recvBytes.length);
            datagramSocket.receive(pRecv);
            String senderIp = pRecv.getAddress().getHostAddress();
            int senderPort = pRecv.getPort();
            System.out.println(String.format("发送方IP:%s ,端口号:%s", senderIp, senderPort));
            System.out.println(new String(recvBytes,0,pRecv.getLength()));
            byte[] content = String.format("Welcome,%s:%s !", senderIp, senderPort).getBytes();
            DatagramPacket pSend = new DatagramPacket(content, content.length);
            pSend.setSocketAddress(new InetSocketAddress(senderIp, senderPort));
            datagramSocket.send(pSend);

        }


    }
}
