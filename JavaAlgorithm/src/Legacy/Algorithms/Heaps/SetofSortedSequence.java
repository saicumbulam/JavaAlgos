package Legacy.Algorithms.Heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SetofSortedSequence {

    public class ArrayContainer implements Comparable<ArrayContainer> {
        int[] arr;
        int index;

        public ArrayContainer(int[] arr, int index) {
            this.arr = arr;
            this.index = index;
        }

        @Override
        public int compareTo(ArrayContainer o) {
            return this.arr[this.index] - o.arr[o.index];
        }
    }

    public int[] mergeKSortedArray(int[][] arr) {
        //PriorityQueue is heap in Java
        PriorityQueue<ArrayContainer> heap = new PriorityQueue<ArrayContainer>();
        int total=0;

        //add arrays to heap
        for (int i = 0; i < arr.length; i++) {
            heap.add(new ArrayContainer(arr[i], 0));
            total = total + arr[i].length;
        }

        int m=0;
        int result[] = new int[total];

        //while heap is not empty
        while(!heap.isEmpty()){
            ArrayContainer ac = heap.poll();
            result[m++]=ac.arr[ac.index];

            if(ac.index < ac.arr.length-1){
                heap.add(new ArrayContainer(ac.arr, ac.index+1));
            }
        }

        return result;
    }
}
