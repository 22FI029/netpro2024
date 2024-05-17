

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TaskClientOnce {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            System.out.println("localhostの" + port + "番ポートに接続を要求します");
            Socket socket = new Socket("localhost", port);
            System.out.println("接続されました");

            System.out.print("計算する数字を入力してください → ");
            int number = scanner.nextInt();

            TaskObject task = new TaskObject();
            task.setExecNumber(number);

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(task);
            oos.flush();
            

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            TaskObject receivedTask = (TaskObject) ois.readObject();

            int result = receivedTask.getResult();
            System.out.println("サーバからの最大素数は: " + result);

            ois.close();
            oos.close();
            socket.close();
            scanner.close();

        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            e.printStackTrace();
        }
    }
}
