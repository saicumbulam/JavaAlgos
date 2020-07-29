package Leetcode.String.Medium;

import java.util.ArrayList;
import java.util.List;

public class ZigZagPattern {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;

        System.out.println(Calculate(s, numRows));
    }

    private static String Calculate(String s, int numRows)
    {
        if (numRows == 1)
        {
            return s;
        }

        List<StringBuilder> result = new ArrayList<>();
        for (int i = 0; i < Math.min(s.length(), numRows); i++) {
            result.add(new StringBuilder());
        }

        int curRow = 0;
        boolean goinDown = false;

        for (char c: s.toCharArray()
             ) {
            result.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows-1)
            {
                goinDown = !goinDown;
            }

            curRow += goinDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder item: result
             ) {
            ret.append(item);
        }
        return ret.toString();
    }
}
