package InterViewPrep;

public class StrongPasswordChecker {
    public static void main(String[] args) {
        //String str = "Geeksforgeeks";
        //String str = "Geeks1";
        //String str = "";
        String str = "aaa123";
        System.out.println(Calculate(str));
    }

    private static int Calculate(String str)
    {
        boolean isDigit = false;
        boolean isLowerCase = false;
        boolean isUpperCase = false;
        int isRepeating = 0;
        int change = 0;
        int minLength = 6, maxLength = 20;

        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i)))
            {
                isDigit = true;
            }
            if (Character.isLowerCase(str.charAt(i)))
            {
                isLowerCase = true;
            }
            if (Character.isUpperCase(str.charAt(i)))
            {
                isUpperCase = true;
            }
        }
        int occurence = 0;
        int i = 0, j = 0;
        while (j < str.length()) {
            while (j < str.length()-1 && str.charAt(j) == str.charAt(j+1))
            {
                j++;
            }
            if (j - i + 1 > 3)
            {
                occurence += (j-i+1)/3;
            }
            i = j+1;
            j++;
        }

        change += occurence;

        if (!isDigit)
        {
            change++;
        }
        if (!isLowerCase)
        {
            change++;
        }
        if (!isUpperCase)
        {
            change++;
        }
        // 3, 3 => 6
        int extra = 0;
        if ((str.length() + change) < minLength)
        {
            extra = minLength - (str.length() + change);
        }
        else if (str.length() + change > maxLength)
        {
            extra = (str.length() + change) - maxLength;
        }
        change += extra;

        return change;

    }
}
