import java.util.Arrays;
import java.util.Random;


public class HeikinCKadai {
	public static void main(String[] args){
		Kamoku[] kamokus = new Kamoku[100];
        Random rand = new Random();
        int totalScore = 0;

	 // 100人の学生にランダムな点数を割り当てる
	for (int i = 0; i < kamokus.length; i++) {
		int score = rand.nextInt(101); // 0から100までのランダムな整数
		kamokus[i] = new Kamoku(score);
		totalScore += score;
	}

    // 全員の平均点を計算して出力
	double averageScore = (double) totalScore / kamokus.length;
	System.out.println("全員の平均点は " + averageScore + " です");


	// 合格者を抽出し、配列にコピー
        int count = 0;
        for (Kamoku kamoku : kamokus) {
            if (kamoku.getScore() >= 80) {
                count++;
            }
        }
        
        int[] passScores = new int[count];
        int index = 0;
        for (Kamoku kamoku : kamokus) {
            if (kamoku.getScore() >= 80) {
                passScores[index++] = kamoku.getScore();
            }
        }

        // 合格者の点数を昇順にソート
        Arrays.sort(passScores);
        
        // 合格者一覧を出力
        System.out.println("合格者一覧（点数昇順）:");
        for (int score : passScores) {
            System.out.println("点数：" + score);
        }

	}



}

