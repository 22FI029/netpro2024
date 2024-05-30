package kadai;
//アルファベットを逆順に出力

import java.util.Random;
public class Abcz implements Runnable{

    @Override
    public void run() {
        Random random = new Random();
        for (char c = 'z'; c >= 'a'; c--) {
            System.out.println(c + "_chan thread");
            try {
                Thread.sleep(100+ random.nextInt(500)); // 100ミリ秒待つ
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
