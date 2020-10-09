package InterViewPrep;

import java.util.*;

public class Skyline {
    public static void main(String[] args) {
        int[][] buildings = {{2,9,10},{3,7,15},{5,12,12},{15,20,10}, {19,24,8}};
        System.out.println(Calculate(buildings));
    }

    static class BuildingPoint implements Comparator<BuildingPoint> {
        int x;
        int height;
        boolean start;

        BuildingPoint(int x, int height, boolean isStart){
            this.x = x;
            this.height = height;
            this.start = isStart;
        }

        public BuildingPoint() {

        }

        @Override
        public int compare(BuildingPoint b1, BuildingPoint b2){
            if(b1.x == b2.x){
                if(b1.start && b2.start) return b2.height - b1.height;
                else if(!b1.start && b2.start) return 1;
                else if(b1.start && !b2.start) return -1;
                else if(!b1.start && !b2.start) return b1.height - b2.height;
            }
            return b1.x - b2.x;
        }
    }

    public static List<List<Integer>> Calculate(int[][] buildings) {
        BuildingPoint[] buildingPoints = new BuildingPoint[2 * buildings.length];

        int k = 0;

        for (int[] building : buildings)
        {
            buildingPoints[k++] = new BuildingPoint(building[0], building[2], true);
            buildingPoints[k++] = new BuildingPoint(building[1], building[2], false);
        }

        Arrays.sort(buildingPoints, new BuildingPoint());

        // This must be given reverse order to push the O to the last.
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        map.put(0, 0);
        int previousHeight = 0;
        List<List<Integer>> result = new ArrayList<>();

        for (BuildingPoint item: buildingPoints)
        {
            if (item.start)
            {
                map.compute(item.height, (key, value) -> {
                    if (value == null)
                        return 1;
                    return value+1;
                });
            }
            else
            {
                map.compute(item.height, (key, value) -> {
                    if (value == 1)
                        return null;
                    value -= 1;
                    return value;
                });

            }

            if (map.firstKey() != previousHeight)
            {
                previousHeight = map.firstKey();
                result.add(Arrays.asList(item.x, map.firstKey()));
            }
        }

        return result;
    }
}
