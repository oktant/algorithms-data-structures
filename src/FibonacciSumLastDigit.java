import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FibonacciSumLastDigit {
    static List<Integer> arrayList = new ArrayList<>();


    private static long getFibonacciSumNaive(long n) {
        getFibonacciHugeNaive(n);

        long a=sum((int)n%60);
        long full=a/60;
        long k=0;
        if(full>0) {
            k=full*(arrayList.stream().parallel().mapToInt(Integer::intValue).sum()-1);
        }
        return k+a;

    }

    public static long sum(int index) {
        int sum = 0;
        for (int j = 0; j <= index; j++) {
            sum=sum+arrayList.get(j);
        }
        return sum;

    }

    private static void getFibonacciHugeNaive(long n) {
        arrayList.add(0);
        arrayList.add(1);
        int i=0;
        while (i < 60) {
            long temp = arrayList.get(i) % 10;
            long temp1 = arrayList.get(i + 1) % 10;
            long add = (temp + temp1) % 10;

            arrayList.add((int) add);
            i++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumNaive(n);
        System.out.println(s);
    }
}

