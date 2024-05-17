import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) {
        try {
            // IPアドレスを指定してInetAddressオブジェクトを取得
            InetAddress addr = InetAddress.getByName("8.8.8.8");
            
            // ホスト名を取得して表示
            System.out.println("Host name is: " + addr.getHostName());
            
            // IPアドレスを取得して表示
            System.out.println("Ip address is: " + addr.getHostAddress());
        } catch (UnknownHostException e) {
            System.out.println("Could not resolve the IP address.");
            e.printStackTrace();
        }
    }
}

