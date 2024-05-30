package kadai;

/*
UDPのマルチキャスト通信は、特定のグループに属する複数の受信者に同時
にデータを送信するための通信手法。これは、同じデータを複数の受信者
に一斉に送信するために便利。マルチキャストアドレスは特定の範囲に限定
されており、IPv4では 224.0.0.0 から 239.255.255.255 の範囲。
 */
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MulticastClient {
    public static void main(String[] args) {
        try {
            // 自分のPC内でやる場合
            InetAddress group = InetAddress.getByName("224.0.0.1");
            // 隣の人とやる場合
            // InetAddress group = InetAddress.getByName("239.0.0.1");
            int port = 12345;

            // データ送信用のソケットを作成
            DatagramSocket socket = new DatagramSocket();

            // 送信するコマンドを設定
            String command = "Hello, Multicast!";

            // コマンドをバイト配列に変換して DatagramPacket を作成し、マルチキャストグループに送信
            byte[] buffer = command.getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, port);
            socket.send(packet);

            System.out.println("Command sent: " + command);

            // ソケットを閉じる
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

