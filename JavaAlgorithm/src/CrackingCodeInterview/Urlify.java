package CrackingCodeInterview;

import java.util.Arrays;

public class Urlify {
    public static void main(String[] args) {
        replaceSpaces("Mr John Smith               ".toCharArray(), 13);
    }

    public static void replaceSpaces(char[] str, int trueLength) {
        int numSpaces = 0;
        for (int i = 0; i < trueLength; i++) {
            if (str[i] == ' ') numSpaces++;
        }

        // num space*2 coz %20 occupies 2 spaces more than ' '
        int newIndex = trueLength-1 + numSpaces*2;

        // put null if original string is too less
        int i = newIndex+1;
        while (i < str.length)
        {
            str[i] = '\0';
            i++;
        }


        for (int oldIndex = trueLength-1; oldIndex >= 0 ; oldIndex--) {
            if (str[oldIndex] == ' ')
            {
                str[newIndex] = '0';
                str[newIndex-1] = '2';
                str[newIndex-2] = '%';
                newIndex -= 2;
            }
            else
            {
                str[newIndex] = str[oldIndex];
            }
            newIndex--;
        }
    }
}
