public class NoHolidayException extends Exception {
    
    public NoHolidayException(String message) {
        super(message);
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
        System.err.println("この日は平日だよ！はたらきたくないねー。エラーメッセージです。");
    }
}