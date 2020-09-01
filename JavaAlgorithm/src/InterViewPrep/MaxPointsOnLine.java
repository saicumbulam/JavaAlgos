package InterViewPrep;

import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;

public class MaxPointsOnLine {
    public static void main(String[] args) {
        int[][] arr = {{1,1},{2,2},{3,3}};
        System.out.println(Calculate(arr));
    }

    private static int Calculate(int[][] arr)
    {
        int result = 0;

        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            points.add(new Point(arr[i][0], arr[i][1]));
        }

        for (int i = 0; i < points.size(); i++) {

            int max = 0;
            int overlap = 0;
            map.clear();

            for (int j = i+1; j < points.size(); j++) {
                // slope numerator and denominator
                int x = points.get(j).x - points.get(i).x;
                int y = points.get(j).y - points.get(i).y;

                if (x == 0 && y == 0)
                {
                    overlap++;
                    continue;
                }

                int gcd = GenerateGcd(x, y);
                if (gcd != 0)
                {
                    x /= gcd;
                    y /= gcd;
                }

                if (map.containsKey(x))
                {
                    map.get(x).put(y, map.get(x).getOrDefault(y, 0) + 1);
                }
                else
                {
                    HashMap<Integer, Integer> m = new HashMap<>();
                    m.put(y,1);
                    map.put(x, m);
                }

                max = Math.max(max, map.get(x).get(y));
            }
            //global result will be max of running result and sum of max + overlap (to consider points that overlap) + 1 to consider current point in consideration
            result = Math.max(result, max + overlap+1);
        }

        return result;
    }

    private static int GenerateGcd(int x, int y)
    {
       if (y == 0)
           return x;

       return GenerateGcd(y, x%y);
    }

    static class Point
    {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
