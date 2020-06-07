package Legacy.Algorithms.Stack;

public class driver {
    private static Stack stack = new Stack();

    public static void main(String[] args) {

        for (int i = 1; i < 10; i++) {
            stack.push(i);
        }
        System.out.println(stack.toString());
    }
}
