import java.util.*;

public class CoveringSegments {
    private static  List<Segment> intersectionList=new ArrayList<>();
    private static int[] optimalPoints(Segment[] segments) {
        //write your code here
        List<Integer> points = new ArrayList<>();

        if(segments.length==1){

            return new int[]{segments[0].start};
        }
        Arrays.sort(segments, (a,b) -> {
           if(a.start<b.start) return -1;
           else return 1;
        });

        for(int i=0; i<segments.length; i++) {
            int size=intersectionList.size();
            if(size>0) {
               intersection(intersectionList.get(size-1), segments[i]);
            }
            else {
                intersection(segments[i], segments[i + 1]);
                i++;
            }
        }
        intersectionList.forEach(r->points.add(r.start));
        return  points.stream().mapToInt(i->i).toArray();
    }

    private static void intersection(Segment a, Segment b){
        int size=intersectionList.size();
        int e = Math.max(a.start, b.start);
        int f = Math.min(a.end, b.end);

        if (e <= f) {
            if(size>0){
                intersectionList.remove(intersectionList.size()-1);
            }
            intersectionList.add(new Segment(e, f));

        }
        else{
            if(size>0){
                intersectionList.add(b);

            }
            else
            {
                intersectionList.add(a);
                intersectionList.add(b);
            }
        }

    }

    private static class Segment  {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Segment{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 
