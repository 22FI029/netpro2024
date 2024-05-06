import java.util.Scanner;

public class Calc2Scanner {

	public static void main(String[] args) {
		int i=0;
		while(i<10) {
			Scanner scan = new Scanner(System.in);
            System.out.println("2つの数字を入力してください:");

			String str = scan.next();
        
			System.out.println("最初のトークンは: " + str);
            int num1=Integer.parseInt(str);

			str = scan.next();
            
			System.out.println("次のトークンは  : " + str);
			int num2=Integer.parseInt(str);
        
			i++;
            int sum=num1+num2;

             // 結果を出力
            System.out.println("足し算結果: " +sum);
		}


	}
}

//  課題    キーボードから2つの数字を打ち込む
//     その足し算結果を、出力する。