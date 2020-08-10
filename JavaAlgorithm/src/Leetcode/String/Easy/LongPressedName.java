package Leetcode.String.Easy;

public class LongPressedName {
    public static void main(String[] args) {

        System.out.println(isLongPressedName("vtkgn", "vttkgnn"));
    }
    private static boolean isLongPressedName(String name, String typed) {
        int start1 = 0, start2 = 0;
        int length1 = name.length();
        int length2 = typed.length();

        while(start2 < length2 && start1 < name.length())
        {
            if(name.charAt(start1) == typed.charAt(start2))
            {
                start1++;
                start2++;
            }
            else if (name.charAt(start1) != typed.charAt(start2))
            {
                if(start1 == 0)
                {
                    return false;
                }
                if(name.charAt(start1-1) != typed.charAt(start2))
                {
                    return false;
                }
                start2++;
            }
        }

        if (start1 == length1)
        {
            return true;
        }

        return false;
    }
}
