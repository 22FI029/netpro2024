
    // C言語では、#include に相当する
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

    public class HowOldAreYou {
    
        public static void main(String[] args) {
    
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                // BufferedReader というのは、データ読み込みのクラス(型)
                // クラスの変数を作るには、new を使う。
    
                // readLine() は、入出力エラーの可能性がある。エラー処理がないとコンパイルできない。
                //  Java では、 try{ XXXXXXXX }  catch(エラーの型 変数) { XXXXXXXXXXXXXXXXXX} と書く
            
            while(true){
                try {
                System.out.println("何歳ですか?(終了するには 'q' または 'e' を入力)");
                String line = reader.readLine();

                // 終了処理
                if (line.equals("q") || line.equals("e")) {
                    System.out.println("プログラムを終了します。");
                    break;
                }

                int age = Integer.parseInt(line);//

                
                //年齢の入力が正しいかどうか
                if (age < 0 || age > 120) {
                    System.out.println("入力された年齢が無効です。0歳から120歳の間で入力してください。");
                    continue;
                }

                System.out.println("あなたは" + age + "歳ですね。");
                System.out.println("あなたは2030年、" + (age + 6) + "歳ですね。");

                
                //生まれた年を計算する
                int birthYear =2023-age;
                String era=getJapaneseEra(birthYear);
                int yearInEra = birthYear - getEraStartYear(era) + 1; // 元年を含める計算
                System.out.println("あなたは " + era + " " + yearInEra + " 年に生まれました。");
            }
        
            catch(IOException e) {
                System.out.println(e);
            }
            }
        }



        
        private static String getJapaneseEra(int year) {
            if (year >= 2019) return "令和";
            else if (year >= 1989) return "平成";
            else if (year >= 1926) return "昭和";
            else if (year >= 1912) return "大正";
            else return "明治";
        }
    
        private static int getEraStartYear(String era) {
            switch (era) {
                case "令和": return 2019;
                case "平成": return 1989;
                case "昭和": return 1926;
                case "大正": return 1912;
                default: return 1868; // 明治
            }
        }
    
        
    }
    
    //  課題    キーボードから数字を打ち込む
    //  その結果、 あなたは、???歳ですね、と画面に表示させる。
    //  その後、あなたは10年後、????歳ですね、と画面に表示させる。
    
    

