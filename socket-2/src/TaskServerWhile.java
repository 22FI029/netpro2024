import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TaskServerWhile {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("サーバーがポート5000で待機しています...");

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                    ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
                    ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream())) {

                    System.out.println("クライアント接続: " + clientSocket.getInetAddress());
                    TaskObject task = (TaskObject) ois.readObject();

                    if (task.getExecNumber() <= 1) {
                        System.out.println("1以下の入力がされたためサーバを終了します。");
                        break;
                    }

                    task.exec();
                    oos.writeObject(task);
                    oos.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            }
        } catch (Exception e) {
            System.err.println("サーバーエラー: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
