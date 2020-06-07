package Legacy.Algorithms.Stack;

public class MaxApi {
    private Stack mainStack = new Stack();
    private Stack track = new Stack();

    public void push(int value){
        mainStack.push(value);
        if (mainStack.getSize() == 1) {
            track.push(value);
            return;
        }

        if (value > track.Peek()) {
            track.push(value);
        } else {
            track.push(track.Peek());
        }
    }

    public int getMax(){
        return track.Peek();
    }

    public void Pop(){
        track.Pop();
        mainStack.Pop();
    }
}
