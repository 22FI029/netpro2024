import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TaskClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("サーバーに接続して計算を開始します...");

        while (true) {
            System.out.print("計算する数字を入力してください (終了は1以下): ");
            int number = scanner.nextInt();

            if (number <= 1) {
                System.out.println("クライアントを終了します。");
                break;
            }

            try (Socket socket = new Socket("localhost", 5000);
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())) {

                PrimeTask task = new PrimeTask();
                task.setExecNumber(number);
                oos.writeObject(task);
                oos.flush();

                PrimeTask resultTask = (PrimeTask) ois.readObject();
                System.out.println("サーバからの最大素数は: " + resultTask.getResult());
            } catch (Exception e) {
                System.err.println("接続エラーまたはデータ転送エラー: " + e.getMessage());
                e.printStackTrace();
                break;
            }
        }
        scanner.close();
    }
}




