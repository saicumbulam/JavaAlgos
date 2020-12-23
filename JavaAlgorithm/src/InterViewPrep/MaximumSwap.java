package InterViewPrep;

import java.util.HashMap;

public class MaximumSwap {
    public static void main(String[] args) {
        System.out.println(Calculate(2736));
    }

    public static int Calculate(int num) {
        char[] digits = String.valueOf(num).toCharArray();

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < digits.length; i++)
        {
            map.put(Character.getNumericValue(digits[i]), i);
        }

        for(int i = 0; i < digits.length; i++)
        {
            for(int k = 9; k > digits[i] - '0'; k--)
            {
                if(map.containsKey(k) && map.get(k) > i)
                {
                    char temp = digits[i];
                    digits[i] = digits[map.get(k)];
                    digits[map.get(k)] = temp;

                    return Integer.parseInt(String.valueOf(digits));
                }
            }
        }

        return num;
    }
}
