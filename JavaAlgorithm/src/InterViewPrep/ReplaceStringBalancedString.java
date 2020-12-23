package InterViewPrep;

import java.util.HashMap;

public class ReplaceStringBalancedString {
    public static void main(String[] args) {
        String str = "QWER";
        System.out.println(calculate(str));
    }

    private static int calculate(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int n = s.length(), res = n, i = 0, k = n / 4;
        for (int j = 0; j < n; ++j) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
        }
        for (int j = 0; j < n; ++j) {
            map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
            while (i < n &&  map.get('Q') <= k && map.get('W') <= k && map.get('E') <= k && map.get('R') <= k) {
                res = Math.min(res, j - i + 1);
                map.put(s.charAt(i), map.get(s.charAt(i)) +1);
                i++;
            }
        }
        return res;
    }
}
