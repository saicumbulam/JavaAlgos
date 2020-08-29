package InterViewPrep;

import java.util.HashMap;
import java.util.StringJoiner;

public class IntegerToEnglishWords {
    static HashMap<Integer, String> map = new HashMap<>();

    public static void main(String[] args) {
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

        //int num = 12345;
        //int num = 123;
        int num = 1234567;
        //int num = 1234567891;
        System.out.println(Calculate(num));
    }

    private static String Calculate(int num)
    {
        StringJoiner str = new StringJoiner(" ");
        if (num >= 1000000000)
        {
            str.add(Convert(num/1000000000) + " Billion");
            num = num % 1000000000;
        }
        if (num >= 1000000)
        {
            str.add(Convert(num/1000000) + " Million");
            num = num % 1000000;
        }
        if (num >= 1000)
        {
            str.add(Convert(num/1000)  + " Thousand");
            num = num % 1000;
        }
        if (num < 1000)
        {
            str.add(Convert(num));
        }

        return str.toString();
    }

    private static String Convert(int num)
    {
        StringJoiner str = new StringJoiner(" ");

        if (num >= 100)
        {
            str.add(map.get(num/100) + " Hundred");
            num = num % 100;
        }
        if (num >= 20 && num < 100)
        {
            str.add(map.get((num/10)  * 10));
            num = num %10;
        }
        if (num < 20)
        {
            str.add(map.get(num));
        }
        return str.toString();
    }
}
