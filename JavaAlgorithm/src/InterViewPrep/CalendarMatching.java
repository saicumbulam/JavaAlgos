package InterViewPrep;

import java.util.ArrayList;
import java.util.List;

public class CalendarMatching {

    public static void main(String[] args) {
        List<StringMeeting> calendar1 = new ArrayList<>();
        calendar1.add(new StringMeeting("9:00", "10:30"));
        calendar1.add(new StringMeeting("12:00", "13:00"));
        calendar1.add(new StringMeeting("16:00", "18:00"));

        List<StringMeeting> calendar2 = new ArrayList<>();
        calendar2.add(new StringMeeting("10:00", "11:30"));
        calendar2.add(new StringMeeting("12:30", "14:30"));
        calendar2.add(new StringMeeting("14:30", "15:00"));
        calendar2.add(new StringMeeting("16:00", "17:00"));

        StringMeeting dailyBounds1 = new StringMeeting("9:00", "20:00");
        StringMeeting dailyBounds2 = new StringMeeting("10:00", "18:30");
        int meetingDuration  =30;
        System.out.println(calendarMatching(calendar1, dailyBounds1, calendar2, dailyBounds2, meetingDuration));
    }
    //time: o(c1+c2) | space: o(c1+c2) - where c1 and c2 are the respective
    // number of meetings for calendar1 and calendar2
    public static List<StringMeeting> calendarMatching(
            List<StringMeeting> calendar1,
            StringMeeting dailyBounds1,
            List<StringMeeting> calendar2,
            StringMeeting dailyBounds2,
            int meetingDuration) {
        List<Meeting> updatedCalendar1 = updateCalendar(calendar1, dailyBounds1);
        List<Meeting> updatedCalendar2 = updateCalendar(calendar2, dailyBounds2);
        List<Meeting> mergedCalendar = mergeCalendars(updatedCalendar1, updatedCalendar2);
        List<Meeting> flattenedCalendar = flattenCalendar(mergedCalendar);
        return getMatchingAvailabilities(flattenedCalendar, meetingDuration);
    }

    private static List<StringMeeting> getMatchingAvailabilities(List<Meeting> calendar, int meetingDuration)
    {
        List<Meeting>	matching = new ArrayList<>();

        for(int i = 1; i < calendar.size(); i++)
        {
            int start = calendar.get(i-1).end;
            int end = calendar.get(i).start;
            int availability = end - start;
            if (availability >= meetingDuration)
            {
                matching.add(new Meeting(start, end));
            }
        }

        List<StringMeeting> matchingInHours = new ArrayList<>();
        for(int i = 0; i < matching.size(); i++)
        {
            matchingInHours.add(new StringMeeting(
                    minutesToTime(matching.get(i).start),
                    minutesToTime(matching.get(i).end)));
        }

        return matchingInHours;
    }

    private static List<Meeting> updateCalendar(List<StringMeeting> calendar,
                                                StringMeeting dailyBounds)
    {
        List<StringMeeting> updatedCalendar = new ArrayList<>();
        updatedCalendar.add(new StringMeeting("0:00", dailyBounds.start));
        updatedCalendar.addAll(calendar);
        updatedCalendar.add(new StringMeeting(dailyBounds.end, "23:59"));
        List<Meeting> calendarInMinutes = new ArrayList<>();
        for(int i = 0; i < updatedCalendar.size(); i++)
        {
            calendarInMinutes.add(new Meeting(
                    timeToMinutes(updatedCalendar.get(i).start),
                    timeToMinutes(updatedCalendar.get(i).end)));
        }

        return calendarInMinutes;
    }

    private static int timeToMinutes(String time)
    {
        int delimiterPos = time.indexOf(":");
        int hours = Integer.parseInt(time.substring(0, delimiterPos));
        int minutes = Integer.parseInt(time.substring(delimiterPos+1));
        return hours*60 + minutes;
    }

    private static String minutesToTime(int minutes)
    {
        int hours = minutes/60;
        int mins = minutes%60;
        String hoursString = String.valueOf(hours);
        String minutesString = mins < 10 ? "0" + String.valueOf(mins) : String.valueOf(mins);
        return hoursString + ":" + minutesString;
    }

    private static List<Meeting> mergeCalendars(List<Meeting> calendar1,
                                                List<Meeting> calendar2)
    {
        List<Meeting> merged = new ArrayList<>();
        int i = 0;
        int j = 0;

        while( i < calendar1.size() && j < calendar2.size())
        {
            Meeting meeting1 = calendar1.get(i);
            Meeting meeting2 = calendar2.get(j);

            if(meeting1.start < meeting2.start)
            {
                merged.add(meeting1);
                i++;
            }
            else
            {
                merged.add(meeting2);
                j++;
            }
        }

        while(i < calendar1.size()) merged.add(calendar1.get(i++));
        while(j < calendar2.size()) merged.add(calendar2.get(j++));
        return merged;
    }

    private static List<Meeting> flattenCalendar(List<Meeting> calendar)
    {
        List<Meeting> flattend = new ArrayList<>();
        flattend.add(calendar.get(0));

        for(int i =1; i < calendar.size(); i++)
        {
            Meeting currentMeeting = calendar.get(i);
            Meeting previousMeeting = flattend.get(flattend.size()-1);

            if(previousMeeting.end >= currentMeeting.start)
            {
                Meeting newPreviousMeeting =
                        new Meeting(previousMeeting.start, Math.max(previousMeeting.end,
                                currentMeeting.end));
                flattend.set(flattend.size()-1, newPreviousMeeting);
            }
            else
            {
                flattend.add(currentMeeting);
            }
        }

        return flattend;

    }

    static class StringMeeting {
        public String start;
        public String end;

        public StringMeeting(String start, String end) {
            this.start = start;
            this.end = end;
        }
    }

    static class Meeting {
        public int start;
        public int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
