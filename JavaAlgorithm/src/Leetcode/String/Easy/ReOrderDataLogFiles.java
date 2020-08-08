package Leetcode.String.Easy;

import java.util.*;

public class ReOrderDataLogFiles {
    static class Element
    {
        String letter;
        int iden;
        int seq;
        boolean letterLog;
        String value;

        public Element(String letter, int iden, int seq, boolean letterLog, String value) {
            this.letter = letter;
            this.iden = iden;
            this.seq = seq;
            this.letterLog = letterLog;
            this.value = value;
        }

        public String toString()
        {
            return value;
        }
    }

    static class CompareElement implements Comparator<Element>
    {
        //-1 is lesser, 1 is greater and 0 is equal in compare method
        public int compare(Element e1, Element e2)
        {
            if (e1.letterLog && !e2.letterLog)
            {
                return -1;
            }
            if (!e1.letterLog && e2.letterLog)
            {
                return 1;
            }
            if (!e1.letterLog && !e2.letterLog)
            {
                return e1.seq > e2.seq ? 1 : -1;
            }
            int lexiCompare = e1.letter.compareTo(e2.letter);
            if (lexiCompare == 0)
            {
                return e1.iden > e2.iden ? 1: -1;
            }
            else
            {
                return lexiCompare;
            }
        }
    }

    public static void main(String[] args) {
        String[] arr = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        System.out.println(Calculate(arr));
    }

    private static List<Element>Calculate(String[] arr)
    {
        List<Element> result = new ArrayList<>();
        int seq = 0;

        for (String word: arr
             ) {
            String[] split = word.split(" ");
            boolean letterLog = true;
            if (Character.isDigit(split[1].charAt(0)))
            {
                letterLog = false;
            }
            int iden = Character.getNumericValue(split[0].charAt(split[0].length()-1));
            String letter = split[1];
            seq++;
            result.add(new Element(letter, iden, seq, letterLog, word));
        }

        Collections.sort(result, new CompareElement());
        return result;
    }
}
