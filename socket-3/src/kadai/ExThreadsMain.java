package kadai;

public class ExThreadsMain {

    public static void main(String[] args) {
        // アルファベットを逆順に出力するスレッド
        Abcz azReverseRunnable = new Abcz();
        Thread azReverseThread = new Thread(azReverseRunnable, "AZ_Reverse_thread");

        // フィボナッチ数列を出力するスレッド
        Fibonacci fibonacciRunnable = new Fibonacci();
        Thread fibonacciThread = new Thread(fibonacciRunnable, "Fibonacci_thread");

        // スレッドを開始
        azReverseThread.start();
        fibonacciThread.start();

        // メインスレッドの動作
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(500); // 500ミリ秒待つ
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 全てのスレッドの終了を待つ
        try {
            azReverseThread.join();
            fibonacciThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

