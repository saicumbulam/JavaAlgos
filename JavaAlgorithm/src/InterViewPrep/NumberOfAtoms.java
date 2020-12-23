package InterViewPrep;

import java.util.*;

public class NumberOfAtoms {
    public static void main(String[] args) {
        System.out.println(countOfAtoms("(B2O39He17BeBe49)39"));
    }

    public static String countOfAtoms(String formula) {
        Stack<HashMap<String, Integer>> stack = new Stack<>();
        int n = formula.length();
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < formula.length(); ) {
            char c = formula.charAt(i);

            if (c == '(') {
                stack.push(map);
                map = new HashMap<>();
                i++;
            } else if (c == ')') {
                HashMap<String, Integer> temp = map;
                map = stack.pop();
                int start = i;
                int val = 0;
                while (i < n - 1 && Character.isDigit(formula.charAt(i + 1))) {
                    i++;
                    val = val * 10 + formula.charAt(i) - '0';
                }

                if (val == 0) val = 1;

                for (int j = 0; j < val; j++) {
                    for (Map.Entry<String, Integer> entry : temp.entrySet()) {
                        if (!map.containsKey(entry.getKey())) {
                            map.put(entry.getKey(), 0);
                        }
                        map.put(entry.getKey(), map.get(entry.getKey()) + entry.getValue());
                    }
                }
                i++;
            } else {
                int start = i;
                while (i < n - 1 && Character.isLowerCase(formula.charAt(i + 1))) {
                    i++;
                }

                String first = formula.substring(start, i+1);

                int val = 0;
                while (i < n - 1 && Character.isDigit(formula.charAt(i + 1))) {
                    i++;
                    val = val * 10 + formula.charAt(i) - '0';
                }

                if (val == 0) val = 1;

                if (!map.containsKey(first)) {
                    map.put(first, 0);
                }
                map.put(first, map.get(first) + val);
                i++;
            }
        }

        StringBuilder str = new StringBuilder();
        List<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        for (String item : keys) {
            str.append(item);
            if (map.get(item) > 1) {
                str.append(map.get(item));
            }
        }

        return str.toString();
    }
}

