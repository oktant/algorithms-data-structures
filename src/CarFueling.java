import java.util.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
        int[] fullStops =addToArray(dist, stops);

        int numberOfRefills=0;
        int currentRefill = 0;
        int indexOfCurrentRefill = 0;
        if (tank>=dist){
            return 0;
        }
        while(currentRefill<dist){
            int indexFirstRefill= indexOfCurrentRefill;
            while(indexOfCurrentRefill<fullStops.length-1 && fullStops[indexOfCurrentRefill+1]-fullStops[indexFirstRefill]<=tank){
                indexOfCurrentRefill++;
            }
            currentRefill=fullStops[indexOfCurrentRefill];

            if (indexFirstRefill==indexOfCurrentRefill)
                return -1;
            if (currentRefill<dist)
              numberOfRefills++;
        }


        return numberOfRefills;
    }


    public static int[] addToArray(int dist, int[]stops){
        int stopsLength=stops.length;
        int fullStops[]=new int[stopsLength+2];
        fullStops[0]=0;
        fullStops[stopsLength+1]=dist;
        for (int i=0; i<stopsLength; i++){
            fullStops[i+1]=stops[i];
        }
        return fullStops;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}