import java.util.Scanner;

public class Change {
    private static int getChange(int m) { //12
        int temp=m%10;
        return m/10+temp/5+temp%5;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

