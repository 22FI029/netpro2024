import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class MyExceptionHoliday {

	public static void main(String[] args) {

		//MayExceptionTest myE=new MayExceptionTest();
        new MyExceptionHoliday();

	}

	MyExceptionHoliday(){
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader というのは、データ読み込みのクラス(型)
		// クラスの変数を作るには、new を使う。

		// readLine() は、入出力エラーの可能性がある。エラー処理がないとコンパイルできない。
		//  Java では、 try{ XXXXXXXX }  catch(エラーの型 変数) { XXXXXXXXXXXXXXXXXX} と書く

		while(true){
		try {
			System.out.println("何日ですか?");
			String line = reader.readLine();
			int theday = Integer.parseInt(line);
			System.out.println("日付" + theday + "日ですね。");

			
            
            test(theday);

		}
		catch(IOException e) {
			System.out.println(e);
		} catch (NoHolidayException e) {
			e.printStackTrace();
		}
	}

	}

	void test(int theday) throws NoHolidayException{
         LocalDate date = LocalDate.of(2024, 5, theday);  // 2024年5月を例にします（年は必要に応じて変更可能）
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
            System.out.println(theday + "日は休日です。");
		}
			else if (isHoliday(date)) {
				System.out.println(theday + "日は休日です。");
			}
        else {
			throw new NoHolidayException(theday + "日は休日ではありません。");
		}
	}
	boolean isHoliday(LocalDate date) {
        // 令和の日（5月1日）とこどもの日（5月5日）を祝日とします
        return (date.getMonth() == Month.MAY && (date.getDayOfMonth() == 3 || date.getDayOfMonth() == 6));
    }

}
