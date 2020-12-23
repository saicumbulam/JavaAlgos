package CrackingCodeInterview;

public class Permutation {
    public static void main(String[] args) {
        System.out.println(Find("abc", "cpa"));
    }

    private static boolean Find(String str1, String str2) {
        //permutation must be equal space
        if (str1.length() != str2.length()) return false;

        int[] letters = new int[128];
        for (int i = 0; i < str1.length(); i++) {
            letters[str1.charAt(i)]++;
        }

        for (int i = 0; i < str2.length(); i++) {
            if (letters[str2.charAt(i)] == 0) return false;
            letters[str2.charAt(i)]--;
        }

        return true;
    }
}
