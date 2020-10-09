package InterViewPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class PerfectSquares {
    public static void main(String[] args) {
        int n = 12;
        System.out.println(Calculate(n));
    }

    private static int Calculate(int n)
    {
        List<Integer> squares = new ArrayList<>();

        for (int i = 1; i*i <= n; i++)
        {
            squares.add(i*i);
        }

        HashSet<Integer> set = new HashSet<>();
        set.add(n);

        int level = 0;

        while(set.size() > 0)
        {
            level++;
            HashSet<Integer> nextSet = new HashSet<>();

            for (int remainder : set)
            {
                for (int num: squares)
                {
                    if (remainder == num)
                    {
                        return level;
                    }
                    else if (num > remainder)
                    {
                        break;
                    }
                    else
                    {
                        nextSet.add(remainder - num);
                    }
                }
            }

            set = nextSet;
        }

        return level;
    }
}
