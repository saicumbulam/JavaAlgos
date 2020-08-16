/*
Risky
* */
package Leetcode.StackNQueue.Hard;

import java.lang.reflect.Array;
import java.util.*;

public class NumberOfAtoms {
    public static void main(String[] args) {
        //String str = "H2O";
        String str = "Mg(OH)2";
        System.out.println(Calculate(str));
    }

    private static String Calculate(String str)
    {
        List<Element> list = new ArrayList<>();
        boolean first = false;
        int i = 0;

        while (i < str.length()) {
            StringBuilder word = new StringBuilder();
            while (i < str.length() &&
                    !Character.isDigit(str.charAt(i))
            && str.charAt(i) != '(' && str.charAt(i) != ')')
            {
                if (first && Character.isUpperCase(str.charAt(i)))
                {
                    break;
                }
                first = true;
                word.append(str.charAt(i));
                i++;
            }
            int count = 0;

            if (i < str.length() && Character.isDigit(str.charAt(i)))
            {
                count = Character.getNumericValue(str.charAt(i));
                i++;
            }

            if (count > 0)
            {
                list.add(new Element(word.toString(), count));
            }
            else
            {
                list.add(new Element(word.toString(), 0));
            }
        }

        Collections.sort(list, (a,b) -> a.str.compareTo(b.str));
        StringBuilder result = new StringBuilder();
        for (Element e: list
             ) {
            result.append(String.format("%s%s",e.str,e.count == 0 ? "": e.count));
        }
        return result.toString();
    }

    static class Element
    {
        String str;
        int count;

        public Element(String str, int count) {
            this.str = str;
            this.count = count;
        }
    }
}
