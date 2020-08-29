package InterViewPrep;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ConfusingNumber {
    public static void main(String[] args) {
        map.put(0,0);
        map.put(1,1);
        map.put(6,9);
        map.put(8,8);
        map.put(9,6);
        map.put(2,-1);
        map.put(3,-1);
        map.put(4,-1);
        map.put(5,-1);
        map.put(7,-1);


        int num = 11;
        System.out.println(Calculate(num));
    }

    private static boolean Calculate(int num)
    {
        StringBuilder str = new StringBuilder();
        int num1 = num;
        while (num1 != 0)
        {
            if (map.get(num1%10) == -1)
            {
                return false;
            }
            str.insert(0,String.valueOf(map.get(num1%10)));
            num1 = num1/10;
        }
        if (Integer.parseInt(str.toString()) != num)
        {
            return true;
        }
        return false;
    }

    static HashMap<Integer, Integer> map = new HashMap<>();
}
