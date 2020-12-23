package CrackingCodeInterview;

public class isUnique {
    public static void main(String[] args) {
        System.out.println(Find("hello"));
        System.out.println(FindNoUsage("helo"));
    }

    private static boolean Find(String str) {
        //cannot form  a unique char string
        // more than 128 chars long
        if (str.length() > 128) return false;

        boolean[] char_set = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) return false;
            char_set[val] = true;
        }
        return true;
    }


    private static boolean FindNoUsage(String str) {
        for (int i = 0; i < str.length()-1; i++) {
            for (int j = i+1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) return false;
            }
        }
        return true;
    }
}
