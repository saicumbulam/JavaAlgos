package Leetcode.Misc.Easy;

import java.util.HashMap;

public class RomanToInteger {
    static HashMap<Character, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) {
        hashMap.put('M', 1000);
        hashMap.put('D', 500);
        hashMap.put('C', 100);
        hashMap.put('L', 50);
        hashMap.put('X', 10);
        hashMap.put('V', 5);
        hashMap.put('I', 1);

        System.out.println(Converter("IX"));
    }

    private static int Converter(String str) {
        int result = hashMap.get(str.charAt(str.length()-1));

        for (int i = str.length()-2; i >=0 ; i--) {
            int x = hashMap.get(str.charAt(i+1));
            int y = hashMap.get(str.charAt(i));

            if (x > y)
            {
                result = result-y;
            }
            else{
                result = result+y;
            }
        }
        return result;
    }
}
