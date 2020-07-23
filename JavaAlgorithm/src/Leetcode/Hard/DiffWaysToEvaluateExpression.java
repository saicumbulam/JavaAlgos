package Leetcode.Hard;

import java.util.ArrayList;
import java.util.List;

public class DiffWaysToEvaluateExpression {
    public static void main(String[] args) {
        String str = "1+2*3";
        System.out.println(Calculate(str));
    }

    private static List<Integer> Calculate(String str) {
        List<Integer> result = new ArrayList<>();

        // check if the string is a number alone. add to result if its true
        if (!str.contains("+") && !str.contains("*") && !str.contains("-")) {
            result.add(Integer.parseInt(str));
        }
        // Iterate the string. if character is a math, then calculate
        // left and right parts using string substring(0,i) and (i+1)
        // add the result for left and right part for loops
        else {
            for (int i = 0; i < str.length(); i++) {
                char item = str.charAt(i);

                if (!Character.isDigit(item)) {
                    List<Integer> leftParts = Calculate(str.substring(0, i));
                    List<Integer> rightParts = Calculate(str.substring(i + 1));

                    for (int leftPart : leftParts
                    ) {
                        for (int rightPart : rightParts
                        ) {
                            switch (item) {
                                case '+':
                                    result.add(leftPart + rightPart);
                                    break;
                                case '-':
                                    result.add(leftPart - rightPart);
                                    break;
                                case '*':
                                    result.add(leftPart * rightPart);
                                    break;
                            }
                        }
                    }
                }
            }
        }

        return result;
    }
}
