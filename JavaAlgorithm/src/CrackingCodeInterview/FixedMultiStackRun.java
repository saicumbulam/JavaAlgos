package CrackingCodeInterview;

public class FixedMultiStackRun {
    public static void main(String[] args) {
        FixedMultiStack _fixedMultiStack = new FixedMultiStack(10);
        _fixedMultiStack.push(1, 1);
        System.out.println(_fixedMultiStack.pop(2));
    }
}
