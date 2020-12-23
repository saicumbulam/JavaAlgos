package CrackingCodeInterview;

public class OneEditAway {
    public static void main(String[] args) {
        System.out.println(Find("pale", "ple"));
    }

    private static boolean Find(String str1, String str2) {
        if(Math.abs(str1.length() - str2.length()) > 1) return false;

        String s1 = str1.length() < str2.length() ? str1 : str2;
        String s2 = str1.length() < str2.length() ? str2 : str1;

        int index1 = 0;
        int index2 = 0;
        boolean foundDiff = false;

        while (index1 < s1.length() && index2 < s2.length())
        {
            if(s1.charAt(index1) != s2.charAt(index2))
            {
                if (foundDiff) return false;

                foundDiff = true;

                if (s1.length() == s2.length())
                {
                    index1++; // on replace, move shorter pointer
                }
            }
            else
            {
                index1++; // if matching, move shorter pointer
            }
            index2++; //always move longer pointer

        }
        return true;

    }


}
