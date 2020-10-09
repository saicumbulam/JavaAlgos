package InterViewPrep;

import java.util.ArrayList;
import java.util.Stack;
import java.util.List;

public class ExclusiveTimeFunction {
    public static void main(String[] args) {
        int n = 2;
        List<String> logs = new ArrayList<>();
        logs.add("0:start:0");
        logs.add("1:start:2");
        logs.add("1:end:5");
        logs.add("0:end:6");
        System.out.println(Calculate(n, logs));
    }

    public static int[] Calculate(int n, List<String> logs) {
        Stack< Integer > stack = new Stack < > ();
        int[] res = new int[n];
        String[] s = logs.get(0).split(":");
        stack.push(Integer.parseInt(s[0]));
        int i = 1, time = Integer.parseInt(s[2]);
        while (i < logs.size()) {
            s = logs.get(i).split(":");
            while (time < Integer.parseInt(s[2])) {
                res[stack.peek()]++;
                time++;
            }
            if (s[1].equals("start"))
                stack.push(Integer.parseInt(s[0]));
            else {
                res[stack.peek()]++;
                time++;
                stack.pop();
            }
            i++;
        }
        return res;
    }
}
