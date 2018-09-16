import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] a) {
        List<String> numbers = new ArrayList<>(Arrays.asList(a));
        String result = "";
        int k = 0;
        while (k < numbers.size()) {

            String maxInteger = Long.MIN_VALUE + "";

            for (int i = 0; i < numbers.size(); i++) {
                if (isGreaterOrEqual(numbers.get(i), maxInteger + "")) {
                    maxInteger = numbers.get(i);

                }

            }
            result += maxInteger;
            numbers.remove(maxInteger);

        }
        k++;
        return result;
    }


    public static boolean isGreaterOrEqual(String digit, String maxDigit) {
            if(maxDigit.charAt(0)=='-'){
                return true;
            }
            else{
                if(Long.parseLong(digit+maxDigit)>Long.parseLong(maxDigit+digit)){
                    return true;
                }
                return false;
            }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

