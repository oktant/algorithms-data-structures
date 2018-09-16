import java.util.Scanner;

public class Fibonacci {
  private static int calc_fib(int n) {
    int fib[][]=new int[][]{{1,1},{1,0}};
    if(n==0){
    	return n;
    }
    else{
    	power(fib, n-1);
    	return fib[0][0];
    }

  }
  private static void multiply(int[][] fib, int[][] initialMatrix){
  	int x=fib[0][0]*initialMatrix[0][0]+ fib[0][1]*initialMatrix[1][0];
  	int y=fib[0][0]*initialMatrix[0][1]+ fib[0][1]*initialMatrix[1][1];
	int z =  fib[1][0]*initialMatrix[0][0] + fib[1][1]*initialMatrix[1][0];
    int w =  fib[1][0]*initialMatrix[0][1] + fib[1][1]*initialMatrix[1][1]; 	
    fib[0][0] = x;
    fib[0][1] = y;
    fib[1][0] = z;
    fib[1][1] = w;

  }

 

  private static void power(int[][] fib, int n){
  	int i;
    int initialMatrix[][]=new int[][]{{1,1},{1,0}};
    	for(i=2; i<=n; i++){
    		multiply(fib,initialMatrix);
    	}

  }




  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib(n));
  }
}
