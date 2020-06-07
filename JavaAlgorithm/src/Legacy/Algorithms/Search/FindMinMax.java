package Legacy.Algorithms.Search;

import java.util.List;


public class FindMinMax {
    public static class MinMax{
        public Integer smallest;
        public Integer largest;

        public MinMax(Integer smallest, Integer largest) {
            this.smallest = smallest;
            this.largest = largest;
        }

        public static MinMax minMax(Integer a, Integer b){
            return Integer.compare(b,a) < 0? new MinMax(b,a): new MinMax(a,b);
        }
    }

    public MinMax findMinMax(List<Integer> array){
        if (array.size() < 1) {
            return new MinMax(array.get(0), array.get(0));
        }

        MinMax globalmax = MinMax.minMax(array.get(0), array.get(1));

        //process two elements at a time

        for (int i = 2; i + 1 < array.size(); i += 2) {
            MinMax localMinMax = MinMax.minMax(array.get(i) , array.get(i+1));
            globalmax = new MinMax(Math.min(globalmax.smallest, localMinMax.smallest),
                    Math.max(globalmax.largest, localMinMax.largest));
        }

        //if there is no odd number of elements in array, we still need to compare the
        // last element with existing answer

        if ((array.size()%2) != 0) {
            globalmax = new MinMax(Math.min(globalmax.smallest, array.get(array.size() -1 )),
                    Math.max(globalmax.largest, array.get(array.size() - 1)));
        }
        return globalmax;
    }


}
