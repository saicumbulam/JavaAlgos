package CrackingCodeInterview;

public class StringCompression {
    public static void main(String[] args) {
        System.out.println(Find("aabccccaaa"));
    }

    private static String Find(String str) {
        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < str.length()) {
            int count = 0;
            char ch = str.charAt(i);
            while (i < str.length() && str.charAt(i) == ch)
            {
                count++;
                i++;
            }
            result.append(ch).append(String.valueOf(count));
        }

        return result.toString();
    }


}
