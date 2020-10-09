package Leetcode.Subsets.Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiffWaysToEvaluateExpression {
    public static void main(String[] args) {
        String str = "1+2*3";
        System.out.println(Calculate(str));
    }

    static Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
    private static List<Integer> Calculate(String str) {
        System.out.println(str);
        if (map.containsKey(str)) return map.get(str);

        List<Integer> result = new ArrayList<>();
        if(!str.contains("+") && !str.contains("*") && !str.contains("/"))
        {
            result.add(Integer.parseInt(str));
            return result;
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(!Character.isDigit(str.charAt(i)))
            {
                List<Integer> left = Calculate(str.substring(0, i));
                List<Integer> right = Calculate(str.substring(i+1));
                for (Integer leftItem: left) {
                    for (Integer rightItem: right) {
                        switch (c)
                        {
                            case '+':
                                result.add(leftItem + rightItem);
                                break;
                            case '*':
                                result.add(leftItem * rightItem);
                                break;
                            case '-':
                                result.add(leftItem - rightItem);
                                break;
                        }
                    }
                }
            }
        }
        map.put(str, result);
        return result;
    }

}
