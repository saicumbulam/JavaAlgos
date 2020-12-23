package CrackingCodeInterview;

import java.util.HashSet;

public class PalindromePermutation {
    public static void main(String[] args) {
        String str = "Tact Coa";
        System.out.println(Find(str));
    }

    private static boolean Find(String str) {
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = Character.toLowerCase(str.charAt(i));
            if (ch == ' ') continue;
            if (set.contains(ch))
            {
                set.remove(ch);
            }
            else
            {
                set.add(ch);
            }
        }

        return set.size() == 1 || set.isEmpty();
    }

}
