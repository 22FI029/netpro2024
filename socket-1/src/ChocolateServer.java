

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChocolateServer {

    private static String serverProcess(String type) {
        // チョコレートの種類に応じてバレンタインのお返しを決定する
        switch (type.toLowerCase()) {
            case "milk":
                return "🍫 whiteチョコレートとバラの花束";
            case "dark":
                return "🍫 whiteチョコレートとダイヤモンドの指輪";
            default:
                return "🍫 特別な毒入りのチョコレート";
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            System.out.println("localhostの" + port + "番ポートで待機します");

            try (ServerSocket server = new ServerSocket(port)) {
                while (true) {
                    Socket socket = server.accept();
                    new Thread(() -> handleClient(socket)).start();
                }
            }

        } catch (BindException be) {
            System.err.println("ポート番号が不正、またはポートが既に使用中です。");
            System.err.println("別のポート番号を指定してください。");
        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket socket) {
        try (ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream())) {

            while (true) {
                Chocolate present = (Chocolate) ois.readObject();
                String msgPresent = present.getMessage();
                if (msgPresent.equalsIgnoreCase("quit") || msgPresent.equalsIgnoreCase("exit")) {
                    System.out.println("クライアントが切断されました");
                    break;
                }
                System.out.println("メッセージは" + msgPresent);
                String presentFromClient = present.getType();
                System.out.println("プレゼントの内容は" + presentFromClient+"チョコレート");

                XmasPresent response = new XmasPresent();
                response.setMessage("バレンタインの贈り物を受け取りました！\n" + presentFromClient + "チョコレートありがとう。\nバレンタインのお返しです：" + serverProcess(presentFromClient));
                response.setContent(serverProcess(presentFromClient));

                oos.writeObject(response);
                oos.flush();
            }

        } catch (Exception e) {
            System.err.println("クライアント処理中にエラーが発生しました");
            e.printStackTrace();
        }
    }
}
