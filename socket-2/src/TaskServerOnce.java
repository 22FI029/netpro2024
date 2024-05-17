
    import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
    
    public class TaskServerOnce {
        public static void main(String[] args) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print("ポートを入力してください(5000など) → ");
                int port = scanner.nextInt();
                scanner.close();
                System.out.println("localhostの" + port + "番ポートで待機します");
                ServerSocket server = new ServerSocket(port);
    
                Socket socket = server.accept();
                System.out.println("接続しました。相手の入力を待っています......");
    
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                TaskObject task = (TaskObject) ois.readObject();
                task.exec();
    
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                oos.writeObject(task);
                oos.flush();
    
                ois.close();
                oos.close();
                socket.close();
                server.close();
    
            } catch (Exception e) {
                System.err.println("エラーが発生したのでプログラムを終了します");
                e.printStackTrace();
            }
            
        }
    
}
