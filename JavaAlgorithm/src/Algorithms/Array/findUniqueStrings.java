package Algorithms.Array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class findUniqueStrings {
    private final static int Max_chars = 256;
    public static void main(String[] args) {
        String input = "GeeksforGeeks";
        if(uniqueCharcters(input)){
            System.out.println("The string " + input + " has all unique charcters");
        } else {
            System.out.println("The string " + input + " has not all unique charcters");
        }
    }

    private static boolean uniqueCharcters(String input) {
        // characters are repeated if the length is more than 256 characters
        if(input.length() > Max_chars){
            return false;
        }

        boolean[] chars = new boolean[Max_chars];
        // fill up array with all false
        Arrays.fill(chars, false);

        for (int i = 0; i < input.length(); i++) {
            int index = (int)input.charAt(i);

            // if the value is already true, string is duplicated
            if (chars[index] == true) {
                return false;
            }
            chars[index] = true;
        }
        return true;
    }
}
