package Algorithms.Heaps;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ComputeKClosestStars {
    public class Star implements Comparable<Star> {
        private double x,y,z;

        public Star(double x, double y, double z){
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public double distance() { return Math.sqrt(x*x + y*y + z*z);}


        @Override
        public int compareTo(Star that) {
            return Double.compare(this.distance(), that.distance());
        }
    }

    public List<Star> findClosestKStars(Iterator<Star> stars, int k){
        PriorityQueue<Star> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());

        while (stars.hasNext()){
            // Add each to the max-heap. If the max-heap size exceeds k, remove the maximum element from max-heap
            Star star = stars.next();
            maxHeap.add(star);

            if (maxHeap.size() == k + 1) {
                maxHeap.remove();
            }
        }

        return Stream.generate(maxHeap::remove).limit(maxHeap.size()).collect(Collectors.toList());
    }
}
