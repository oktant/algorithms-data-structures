import java.util.*;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        if (capacity==0) {
            return 0;
        }


        List<Item>  a=new ArrayList<>();
        for(int i=0; i<values.length; i++){
            a.add(new Item(values[i], weights[i]));
        }
        a.sort(Comparator.comparing(Item::getFraction));


        double value = 0;
        int length=values.length;
        for(int i=length-1; i>=0; i--){
            int z=Math.min(a.get(i).getWeight(), capacity);
            capacity=capacity-z;
            value=value+a.get(i).getFraction()*z;
            if (capacity==0) {
                break;
            }

        }


        return value;
    }


    private static class Item{
        int value;
        int weight;
        double fraction;

        public Item(int value, int weight){
            this.value=value;
            this.weight=weight;
            this.fraction=(double)value/weight;


        }

        @Override
        public String toString() {
            return "Item{" +
                    "value=" + value +
                    ", weight=" + weight +
                    ", fraction=" + fraction +
                    '}';
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public double getFraction() {
            return fraction;
        }

        public void setFraction(double fraction) {
            this.fraction = fraction;
        }
    }
    private static int findMax(double [] array){

        double max=0;
        int indexMax=0;
        for (int counter = 1; counter < array.length; counter++)
        {
            if (array[counter] > max)
            {
                max = array[counter];
                indexMax=counter;
            }
        }
        return indexMax;
    }


    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
