package Leetcode.MultiArray.Hard;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.*;

//Need to change algorithmn. It is not passing other tests
public class CutOffTreesGolfEvent {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(2,3,4)));
        list.add(new ArrayList<>(Arrays.asList(0,0,5)));
        list.add(new ArrayList<>(Arrays.asList(8,7,6)));
        System.out.println(cutOffTree(list));
    }

    public static int cutOffTree(List<List<Integer>> forest) {
        if (forest.size() == 0 || forest.get(0).size() == 0)
        {
            return 0;
        }

         int maxCount = 0;

        for (int i = 0; i < forest.size(); i++)
        {
            for (int j = 0; j < forest.get(0).size(); j++)
            {
                if (forest.get(i).get(j) != 0)
                {
                    maxCount++;
                }
            }
        }

        Set<String> set = new HashSet<>();
        int count = dfs(forest, 0, 0, set);

        if (count < maxCount-1)
        {
            return -1;
        }

        return count-1;
    }



    private static int dfs(List<List<Integer>> forest, int r, int c, Set<String> set)
    {
        if (r < 0 || r >= forest.size() || c < 0 || c >= forest.get(0).size() ||
                forest.get(r).get(c) == 0 || set.contains(r + "," + c))
        {
            return 0;
        }

        int count = 1;
        //System.out.println(forest.get(r).get(c));
        forest.get(r).set(c, 1);
        set.add(r + "," + c);
        count += dfs(forest, r+1, c,set);
        count += dfs(forest, r-1, c,set);
        count += dfs(forest, r, c+1,set);
        count += dfs(forest, r, c-1,set);
        return count;
    }
}
