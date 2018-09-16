import java.util.Scanner;

public class FibonacciLastDigit {
    public static int getFibonacciLastDigitNaive(int n) {
         long a=calc_fib(n);
         return Math.abs((int)(a%10));

    }
    private static void multiply(long[][] fib, long[][] initialMatrix){
        fib[0][0]=fib[0][0]%10;
           long x=fib[0][0]*initialMatrix[0][0]+ fib[0][1]*initialMatrix[1][0];
        long y=fib[0][0]*initialMatrix[0][1]+ fib[0][1]*initialMatrix[1][1];
        long z =  fib[1][0]*initialMatrix[0][0] + fib[1][1]*initialMatrix[1][0];
        long w =  fib[1][0]*initialMatrix[0][1] + fib[1][1]*initialMatrix[1][1];
        fib[0][0] = x;
        fib[0][1] = y;
        fib[1][0] = z;
        fib[1][1] = w;

    }

    private static long calc_fib(int n) {
        long fib[][]=new long[][]{{1,1},{1,0}};
        if(n==0){
            return n;
        }
        else{
            power(fib, n-1);
            return fib[0][0];
        }

    }


    private static void power(long[][] fib, int n){
        int i;
        long initialMatrix[][]=new long[][]{{1,1},{1,0}};
        for(i=2; i<=n; i++){
            multiply(fib,initialMatrix);
        }

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigitNaive(n);
        System.out.println(c);
    }
}

