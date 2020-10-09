package InterViewPrep;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(Calculate(candidates, target));
    }

    private static List<List<Integer>> Calculate(int[] candidates, int target)
    {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        backtrack(target, new ArrayList<>(), 0, candidates, results);
        return results;
    }

    private static void backtrack(int target, List<Integer> curr, int start,
                                  int[] num, List<List<Integer>> results) {

        if(target == 0)
        {
            results.add(new ArrayList<>(curr));
            return;
        }
        else if ( target < 0)
        {
            return;
        }

        // add the number any times to the target
        for (int i = start; i < num.length; i++) {
            curr.add(num[i]);
            backtrack(target - num[i], curr, i, num, results);
            curr.remove(curr.size()-1);
        }
    }


}
