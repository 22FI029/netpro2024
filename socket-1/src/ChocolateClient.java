import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.Socket;
import java.util.Scanner;

public class ChocolateClient {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();

            System.out.println("localhostの" + port + "番ポートに接続を要求します");
            try (Socket socket = new Socket("localhost", port);
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())) {
                System.out.println("接続されました");

                while (true) {
                    System.out.println("メッセージを入力してください(終了する場合はquitまたはexitを入力してください) ↓");
                    String message = scanner.next();
                    if (message.equalsIgnoreCase("quit") || message.equalsIgnoreCase("exit")) {
                        System.out.println("接続を終了します");
                        Chocolate chocolate = new Chocolate();
                        chocolate.setMessage(message);
                        oos.writeObject(chocolate);
                        oos.flush();
                        break;
                    }
                    System.out.println("チョコレートの種類を選んでください (milk/dark) ↓");
                    String content = scanner.next();

                    Chocolate chocolate = new Chocolate();
                    chocolate.setMessage(message);
                    chocolate.setType(content);

                    oos.writeObject(chocolate);
                    oos.flush();

                    XmasPresent okaeshiPresent = (XmasPresent) ois.readObject();

                    String replayMsg = okaeshiPresent.getMessage();
                    System.out.println("サーバからのメッセージは" + replayMsg);
                    String replayContent = okaeshiPresent.getContent();
                    System.out.println(replayContent + "をもらいました！");
                }
            }

        } catch (BindException be) {
            be.printStackTrace();
            System.err.println("ポート番号が不正か、サーバが起動していません");
            System.err.println("サーバが起動しているか確認してください");
            System.err.println("別のポート番号を指定してください(6000など)");
        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            throw new RuntimeException(e);
        }
    }
}
