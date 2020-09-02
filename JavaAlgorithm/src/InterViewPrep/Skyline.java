package InterViewPrep;

import java.util.*;

public class Skyline {
    public static void main(String[] args) {
        int[][] buildings = {{1,3,4},{3,4,4},{2,6,2},{8,11,4}, {7,9,3},{10,11,2}};
        List<int[]> list = Calculate(buildings);

        for (int[] item: list
             ) {
            System.out.println(item[0] + ", " + item[1]);
        }
    }

    static class Edge
    {
        int x;
        boolean isStart;
        int height;

        public Edge(int x, boolean isStart, int height) {
            this.x = x;
            this.isStart = isStart;
            this.height = height;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "x=" + x +
                    ", isStart=" + isStart +
                    ", height=" + height +
                    '}';
        }
    }
    static class BuildingPoint implements Comparable<BuildingPoint> {
        int x;
        boolean isStart;
        int height;

        public BuildingPoint(int x, boolean isStart, int height) {
            this.x = x;
            this.isStart = isStart;
            this.height = height;
        }

        @Override
        public int compareTo(BuildingPoint o) {
            //first compare by x.
            //If they are same then use this logic
            //if two starts are compared then higher height building should be picked first
            //if two ends are compared then lower height building should be picked first
            //if one start and end is compared then start should appear before end
            if (this.x != o.x) {
                return this.x - o.x;
            } else {
                return (this.isStart ? -this.height : this.height) -
                        (o.isStart ? -o.height : o.height);
            }
        }
    }

    private static List<int[]> Calculate(int[][] buildings)
    {
        List<Edge> list = new ArrayList<>();

        BuildingPoint[] buildingPoints = new BuildingPoint[buildings.length*2];
        int index = 0;
        for(int[] building : buildings) {
            buildingPoints[index++] =
                    new BuildingPoint(building[0],true, building[2]);
            buildingPoints[index++] =
                    new BuildingPoint(building[1],false, building[2]);
        }

        Arrays.sort(buildingPoints);

        //using TreeMap because it gives log time performance.
        //PriorityQueue in java does not support remove(object) operation in log time.
        TreeMap<Integer, Integer> queue = new TreeMap<>();
        //PriorityQueue<Integer> queue1 = new PriorityQueue<>(Collections.reverseOrder());
        queue.put(0, 1);
        //queue1.add(0);
        int prevMaxHeight = 0;
        List<int[]> result = new ArrayList<>();
        for(BuildingPoint buildingPoint : buildingPoints) {
            //if it is start of building then add the height to map. If height already exists then increment
            //the value
            if (buildingPoint.isStart) {
                queue.compute(buildingPoint.height, (key, value) -> {
                    if (value != null) {
                        return value + 1;
                    }
                    return 1;
                });
            } else { //if it is end of building then decrement or remove the height from map.
                queue.compute(buildingPoint.height, (key, value) -> {
                    if (value == 1) {
                        return null;
                    }
                    return value - 1;
                });
                // queue1.remove(cp.height);
            }
            //peek the current height after addition or removal of building x.
            int currentMaxHeight = queue.lastKey();
            //int currentMaxHeight = queue1.peek();
            //if height changes from previous height then this building x becomes critcal x.
            // So add it to the result.
            if (prevMaxHeight != currentMaxHeight) {
                result.add(new int[]{buildingPoint.x, currentMaxHeight});
                prevMaxHeight = currentMaxHeight;
            }
        }
        return result;
    }
}
