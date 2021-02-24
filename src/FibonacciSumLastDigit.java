import java.util.*;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long n) {
        n = (n+2)%60;
        long[] fibNumbers =new long[(int) (n+1)];
        fibNumbers[0]=0;
        fibNumbers[1]=1;
        for(int i=2; i<fibNumbers.length; i++){
            fibNumbers[i]=fibNumbers[i-1]+fibNumbers[i-2];
        }
        return fibNumbers[(int) n]%10-1;

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumNaive(n);
        System.out.println(s);
    }
}
