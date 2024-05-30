package kadai;
//フィボナッチ数列

import java.util.Random;


public class Fibonacci implements Runnable{
    Random random = new Random();
    @Override
    public void run() {
        int n1 = 0, n2 = 1, n3;
        System.out.println("Fibonacci: " + n1 + " thread: " + Thread.currentThread().getName());
        System.out.println("Fibonacci: " + n2 + " thread: " + Thread.currentThread().getName());

        for (int i = 2; i < 10; i++) {
            n3 = n1 + n2;
            System.out.println("Fibonacci: " + n3 + " thread: " + Thread.currentThread().getName());
            n1 = n2;
            n2 = n3;
            try {
                Thread.sleep(100 + random.nextInt(500)); // 100ミリ秒待つ
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
