package InterViewPrep;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class StrobogrammaticNumber2 {
    public static void main(String[] args) {
        System.out.println(Calculate(4));
    }

    public static List<String> Calculate(int n) {
        List<String> result = new ArrayList<>();

        if (n == 0) {
            return result; // empty
        }

        Queue<String> queue = new LinkedList<>();
        // seed with strobogrammatic numbers of size 1 if n is odd
        // else seed wiht empty string
        if (n % 2 != 0) {
            // note 6 and 9 are no s/g only when in pair with each other
            queue.offer("0");
            queue.offer("1");
            queue.offer("8");
        } else {
            queue.offer("");
        }

        while (!queue.isEmpty() && n > 1) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String number = queue.poll();

                if (n > 3) {
                    queue.offer('0' + number + '0');
                }

                queue.offer('1' + number + '1');
                queue.offer('8' + number + '8');
                queue.offer('6' + number + '9');
                queue.offer('9' + number + '6');
            }

            n -= 2;
        }

        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }

        return result;
    }
}
