package Leetcode.Array.Often;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CalendarMatching {
    static class Element {
        public double start;
        public double end;

        public Element(String start, String end) {
            this.start = Convert(start);
            this.end = Convert(end);
        }

        public Element(double start, double end) {
            this.start = start;
            this.end = end;
        }

        private double Convert(String str)
        {
            double result = 0;
            String[] s = str.split(":");
            result = Integer.parseInt(s[0]) + ((double)Integer.parseInt(s[1]))/60;
            return result;
        }

        public String toString()
        {
            return String.format("%s,%s", this.start, this.end);
        }
    }

    public static void main(String[] args) {
        List<Element> calendar1 = new ArrayList<>();
        calendar1.add(new Element("9:00","10:30"));
        calendar1.add(new Element("12:00","13:00"));
        calendar1.add(new Element("16:00","18:00"));

        Element dailyBounds1 = new Element("9:00","20:00");
        List<Element> calendar2 = new ArrayList<>();
        calendar2.add(new Element("10:00","11:30"));
        calendar2.add(new Element("12:30","14:30"));
        calendar2.add(new Element("14:30","15:00"));
        calendar2.add(new Element("16:00","17:00"));
        Element dailyBounds2 = new Element("10:00","18:30");
        System.out.println(Calculate(calendar1, dailyBounds1, calendar2, dailyBounds2));
    }

    private static List<Element> Calculate(List<Element> calendar1, Element dailyBounds1,
                                           List<Element> calendar2, Element dailyBounds2)
    {
        Element newDailyBound = new Element(Math.max(dailyBounds1.start, dailyBounds2.start),
                Math.min(dailyBounds1.end, dailyBounds2.end));


        List<Element> merged = new ArrayList<>();

        for (Element e1: calendar1
             ) {
            if (e1.start >= newDailyBound.start && e1.end <= newDailyBound.end)
            {
                merged.add(e1);
            }
        }

        for (Element e2: calendar2
        ) {
            if (e2.start >= newDailyBound.start && e2.end <= newDailyBound.end)
            {
                merged.add(e2);
            }
        }

        Collections.sort(merged, (a,b) -> (int)a.start - (int)b.start);

        List<Element> flatten = new ArrayList<>();
        double start = merged.get(0).start;
        double end = merged.get(0).end;


        for (int i = 1; i < merged.size(); i++) {
            if (merged.get(i).start <= end)
            {
                end = Math.max(end, merged.get(i).end);
            }
            else
            {
                flatten.add(new Element(start, end));
                start = merged.get(i).start;
                end = merged.get(i).end;
            }
        }
        flatten.add(new Element(start, end));
        flatten.add(new Element(newDailyBound.end, newDailyBound.end));

        List<Element> finalResult = new ArrayList<>();

        for (int i = 0; i < flatten.size()-1; i++) {
            finalResult.add(new Element(flatten.get(i).end, flatten.get(i+1).start));
        }

        return finalResult;
    }
}
