package InterViewPrep;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(Calculate(nums));
    }

    public static List<List<Integer>> Calculate(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(new ArrayList<>());

        for(int item: nums)
        {
            int n = queue.size();
            for (int i = 0; i< n; i++)
            {
                List<Integer> oldPerm = queue.poll();
                for (int j = 0; j <= oldPerm.size(); j++)
                {
                    List<Integer> newPerm = new ArrayList<>(oldPerm);
                    newPerm.add(j, item);

                    if(newPerm.size() == nums.length)
                    {
                        result.add(new ArrayList<>(newPerm));
                    }
                    else
                    {
                        queue.add(new ArrayList<>(newPerm));
                    }
                }
            }
        }

        return result;
    }
}
