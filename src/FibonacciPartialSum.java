import java.util.*;

public class FibonacciPartialSum {
    private static List<Long> fibNumbersList=new ArrayList<>();

    private static long getFibonacciPartialSumNaive(long from, long to) {
        int findElementTillWhichToCount= (int) (to%60);
        int findElementFromWhichToCount= (int) (from%60);
        return addPianoPeriodToTheArray(findElementTillWhichToCount, findElementFromWhichToCount);
    }

    private static long addPianoPeriodToTheArray(int findElementTillWhichToCount, int findElementFromWhichToCount){
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
        int sum;
        if(findElementFromWhichToCount>findElementTillWhichToCount){
            sum=sum(findElementFromWhichToCount, 60)+ sum(0, findElementTillWhichToCount);

        }
        else {
            sum=sum(findElementFromWhichToCount, findElementTillWhichToCount);
        }

        return sum%10;

    }

    private static int sum(int findElementFromWhichToCount, int findElementTillWhichToCount){
        int sum = 0;

        for (int j = findElementFromWhichToCount; j <= findElementTillWhichToCount; j++) {
            sum= (int) (sum+fibNumbersList.get(j));
        }
        return sum;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSumNaive(from, to));
    }
}
