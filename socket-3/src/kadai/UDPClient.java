package kadai;


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        Scanner scanner = null;
        try {
            socket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("localhost");
            

            scanner = new Scanner(System.in);
            System.out.print("送信するメッセージを入力してください: ");
            String message = scanner.nextLine();
            byte[] sendData = message.getBytes();
            
            // 送信パケットを作成
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 9876);
            socket.send(sendPacket);
            System.out.println("クライアント: メッセージを送信しました -> " + message);

            // 受信バッファの準備
            byte[] receiveData = new byte[1024];

            // 返信を受信
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);
            String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("クライアント: サーバからの返信を受信しました -> " + receivedMessage);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}
