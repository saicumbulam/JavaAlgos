package Leetcode.Misc;

import java.util.HashMap;
import java.util.Map;

public class IntegerToEnglishWords {
    public static void main(String[] args) {
        int num = 123;
        System.out.println(Calculate(num));
    }

    private static String Calculate(int num)
    {
        if (num == 0)
        {
            return "Zero";
        }

        StringBuilder sb = new StringBuilder();

        if (num >= 1000000000)
        {
            sb.append(Convert(num/1000000000) + " Billion");
            num = num % 1000000000;
        }
        if (num >= 1000000)
        {
            sb.append(Convert(num/1000000) + " Million");
            num = num % 1000000;
        }
        if (num >= 1000)
        {
            sb.append(Convert(num/1000) + " Thousand");
            num = num % 1000;
        }
        if (num > 0)
        {
            sb.append(Convert(num));
        }

        return sb.toString().trim();
    }

    private static String Convert(int num)
    {
        StringBuilder sb = new StringBuilder();
        Map<Integer,String> map = getMap();

        if (num >= 100)
        {
            sb.append(" " + map.get(num/100) + " Hundred");
            num = num % 100;
        }
        if (num > 20 && num < 100)
        {
            sb.append(" "+map.get((num/10)*10));
            num = num%10;
        }
        if (num > 0)
        {
            sb.append(" " + map.get(num));
        }
        return sb.toString();
    }
    private static Map<Integer,String> getMap(){
        Map<Integer,String> map = new HashMap<>();
        map.put(0,"Zero");
        map.put(1,"One");
        map.put(2,"Two");
        map.put(3,"Three");
        map.put(4,"Four");
        map.put(5,"Five");
        map.put(6,"Six");
        map.put(7,"Seven");
        map.put(8,"Eight");
        map.put(9,"Nine");
        map.put(10,"Ten");
        map.put(11,"Eleven");
        map.put(12,"Twelve");
        map.put(13,"Thirteen");
        map.put(14,"Fourteen");
        map.put(15,"Fifteen");
        map.put(16,"Sixteen");
        map.put(17,"Seventeen");
        map.put(18,"Eighteen");
        map.put(19,"Nineteen");
        map.put(20,"Twenty");
        map.put(30,"Thirty");
        map.put(40,"Forty");
        map.put(50,"Fifty");
        map.put(60,"Sixty");
        map.put(70,"Seventy");
        map.put(80,"Eighty");
        map.put(90,"Ninety");
        return map;
    }
}
