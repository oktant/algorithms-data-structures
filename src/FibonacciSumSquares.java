import java.util.*;

public class FibonacciSumSquares {
    private static final List<Long> fibNumbersList=new ArrayList<>();

    private static long getFibonacciSumSquaresNaive(long n) {
        int findElementTillWhichToCount= (int) (n%60);
        return addPianoPeriodToTheArray(findElementTillWhichToCount);
    }


    private static long addPianoPeriodToTheArray(int findElementTillWhichToCount){
        fibNumbersList.add(0L);
        fibNumbersList.add(1L);
        int i=0;
        while (i < 60) {
            long temp = fibNumbersList.get(i) % 10;
            long temp1 = fibNumbersList.get(i + 1) % 10;
            long add =  ((temp + temp1) % 10);

            fibNumbersList.add(add);
            i++;
        }
        int sum = 0;

        for (int j = 0; j <= findElementTillWhichToCount; j++) {
            sum= (int) (sum+fibNumbersList.get(j)*fibNumbersList.get(j));
        }
        return sum%10;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumSquaresNaive(n);
        System.out.println(s);
    }
}
