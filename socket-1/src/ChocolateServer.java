
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
                return "🍫 チョコレートに加えて、ふわふわのクマのぬいぐるみ";
            case "dark":
                return "🍫 チョコレートに加えて、バラの花束";
            default:
                return "🍫 特別なチョコレート。";
        }
    }
        
    
        public static void main(String arg[]) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print("ポートを入力してください(5000など) → ");
                int port = scanner.nextInt();
                scanner.close();
                System.out.println("localhostの" + port + "番ポートで待機します");
                ServerSocket server = new ServerSocket(port);
    
                Socket socket = server.accept();
                System.out.println("クライアントと接続しました。メッセージの受信を待っています...");
    
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
    
                Chocolate present = (Chocolate) ois.readObject();
    
                String msgPresent = present.getMessage();
                System.out.println("メッセージは" + msgPresent);
                String presentFromClient = present.getType();
                System.out.println("プレゼントの内容は" + presentFromClient);
    
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
    
                XmasPresent response = new XmasPresent();
                response.setMessage("バレンタインの贈り物を受け取りました！\n" + presentFromClient + "チョコレートありがとう。\nバレンタインのお返しです：" + serverProcess(presentFromClient));
                response.setContent(serverProcess(presentFromClient));
    
                oos.writeObject(response);
                oos.flush();
    
                ois.close();
                oos.close();
                socket.close();
                server.close();
    
            } catch (BindException be) {
                be.printStackTrace();
                System.out.println("ポート番号が不正、またはポートが既に使用中です。");
                System.err.println("別のポート番号を指定してください。");
            } catch (Exception e) {
                System.err.println("エラーが発生したのでプログラムを終了します");
                throw new RuntimeException(e);
            }
        
        }}
