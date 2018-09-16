import java.util.*;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {   //8
        List<Integer> summands = new ArrayList<Integer>();
        for(int k=n,l=1; k>0; l++ ){
            if(k<=2*l){
                summands.add(k);
                k =0;
            }
            else {
                summands.add(l);
                k -= l;
            }
        }
        return summands;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}

