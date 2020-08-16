/*
Done
* */
package Leetcode.String.Easy;

import java.util.*;

public class ReOrderDataLogFiles {
    static class Element
    {
        String first;
        boolean isLetter;
        String moreWords;
        String raw;

        public Element(String str)
        {
            this.raw = str;
            Calculate(str);
        }

        private void Calculate(String str)
        {
            String[] split = str.split(" ");
            this.first = split[0];
            if (!Character.isDigit(split[1].charAt(0)))
            {
                isLetter = true;
            }

            if (isLetter)
            {
                moreWords = str.substring(str.indexOf(" ")+1);
            }
        }
    }

    static class ElementCompare implements Comparator<Element>
    {
        public int compare(Element e1, Element e2)
        {
            if (e1.isLetter != e2.isLetter)
            {
                return e1.isLetter ? -1: 1;
            }

            if (!e1.isLetter && !e2.isLetter)
            {
                return 0;
            }

            return e1.moreWords.equals(e2.moreWords) ? e1.first.compareTo(e2.first) :
                    e1.moreWords.compareTo(e2.moreWords);

        }
    }

    public static void main(String[] args) {
        //String[] arr = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        String[] arr = {"j mo", "5 m w", "g 07", "o 2 0", "t q h"};
        String[] result = Calculate(arr);
        for (String item: result
             ) {
            System.out.println(item);
        }
    }

    public static String[] Calculate(String[] logs) {
        List<Element> list = new ArrayList<>();
        for(String log : logs)
        {
            list.add(new Element(log));
        }

        Collections.sort(list, new ElementCompare());

        String[] result = new String[logs.length];
        int index = 0;

        for(Element item: list)
        {
            result[index++] = item.raw;
        }

        return result;
    }
}
