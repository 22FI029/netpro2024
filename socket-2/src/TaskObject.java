public class TaskObject implements ITask {
    private static final long serialVersionUID = 1L;
    private int number;
    private int result;

    @Override
    public void setExecNumber(int x) {
        this.number = x;
    }

    
    public int getExecNumber() {
        return number;
    }
    @Override
    public void exec() {
        this.result = findLargestPrime(number);
    }

    @Override
    public int getResult() {
        return result;
    }


    //n から 2 まで逆順にループし、素数が見つかればそれを返す
    private int findLargestPrime(int n) {
        for (int i = n; i >= 2; i--) {
            if (isPrime(i)) {
                return i;
            }
        }
        return -1;
    }

    //入力x以下の最大素数を求める
    private boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }
}


    
