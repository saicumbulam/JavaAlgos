package Leetcode.Hash.Alter;

import java.util.HashMap;

public class LoggerRateLimiter {
    HashMap<String,  Integer> map;
    /** Initialize your data structure here. */
    public LoggerRateLimiter() {
        map = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!map.containsKey(message))
        {
            map.put(message, timestamp);
            return true;
        }

        int oldTimestamp = map.get(message);
        int interval = timestamp - oldTimestamp;
        if (interval >= 10)
        {
            map.put(message, timestamp);
            return true;
        }
        return false;
    }
}
