import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FibonacciHuge {
    private static long getFibonacciHugeNaive(long n, long m) {  //n=10 m=2
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(0);
        arrayList.add(1);
        int i = 0;
        while(! (i > 0 && arrayList.get(i) == 0 && arrayList.get(i + 1) == 1)) {

           long temp=arrayList.get(i)%m;
           long temp1=arrayList.get(i+1)%m;

            long add=(temp+temp1)%m;
            arrayList.add((int)add);
            i++;
        }
        return arrayList.get((int) (n % i));
    }




    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHugeNaive(n, m));
    }
}

