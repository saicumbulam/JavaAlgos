package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class CamelCase {
    public static void main(String[] args) {
        System.out.println(Calculate("saveChangesInTheEditor"));
        System.out.println(CalculateList("saveChangesInTheEditor"));
    }

    private static List<String> CalculateList(String str) {
        List<String> result = new ArrayList<>();
        boolean firstPassed = false;
        for (int i = 0; i < str.length();) {
            StringBuilder sb = new StringBuilder();

            if (firstPassed)
            {
                sb.append(str.charAt(i++));
            }

            while ( i < str.length() && Character.isLowerCase(str.charAt(i)))
            {
                sb.append(str.charAt(i));
                i++;
            }
            result.add(sb.toString());
            firstPassed = true;
        }
        return result;
    }

    private static int Calculate(String str)
    {
        int count = 1;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                count++;
            }
        }
        return count;
    }
}
