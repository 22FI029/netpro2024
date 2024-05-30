package kadai;

public class CountAZTenRunnable implements Runnable {
    private char character;

    public void setChar(char character) {
        this.character = character;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(character + "_chan  thread:i=" + i);
            try {
                Thread.sleep(100); // 100ミリ秒待つ
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // 26個のスレッドを格納する配列
        Thread[] threads = new Thread[26];


        // 'a'から'z'までのスレッドを作成して開始
        for (char c = 'a'; c <= 'z'; c++) {
            CountAZTenRunnable runnable = new CountAZTenRunnable();
            runnable.setChar(c);
            Thread thread = new Thread(runnable, c + "_thread");
            threads[c - 'a'] = thread;
            thread.start();
        }

        // メインスレッドの動作
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(500); // 500ミリ秒待つ
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 全てのスレッドの終了を待つ
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
