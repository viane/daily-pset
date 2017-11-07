import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<Tuple> ansPoints = new ArrayList<>();
    private List<Tuple> testPoints;
    private Tuple origin = new Tuple(0,0);
    public Solution(List<Tuple> points){
        this.testPoints = points;
    }
    public List<Tuple> findCloestPoints(int k){
        // calculate distance O(n)
        List<Double> distances = new ArrayList<>();
        for(int i =0; i < testPoints.size();i++){
            Tuple point = testPoints.get(i);
            Double distanceToOrigin = point.getX() * point.getX() + point.getY() * point.getY();
            distances.add(distanceToOrigin);
        }

        // create max heap with first k points' distance O(k)
        PriorityQueue heap = new PriorityQueue(k);
        for (int i =0; i<k;i++){
            heap.add(distances.get(i));
        }

        // for rest of points in test set, compare each's distance with the max in the heap, replace O(log(n-k))
        for (int i = k; i <distances.size();i++){
            if (heap.peek() > distances.get(i)) {
                // replace max in help to smaller distance
                heap.poll();
                heap.add(distances.get(i));
            }
        }

        // note here distance list and test point list share same index sequence
        for (int i =0; i < k; i++){
            Double smallestDistance = heap.poll();
            int index = distances.indexOf(smallestDistance);
            ansPoints.add(testPoints.get(index));
        }


        return this.ansPoints;
    }
}
