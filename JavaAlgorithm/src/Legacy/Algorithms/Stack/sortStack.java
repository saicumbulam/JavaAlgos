package Legacy.Algorithms.Stack;

import java.util.Stack;

public class sortStack {
    public void sort(Stack<Integer> s) {
        Stack<Integer> r = new Stack<Integer>();
        while(!s.isEmpty()){
            int tmp = s.pop();
            while(!r.empty() && r.peek() > tmp){
                s.push(r.pop());
            }
            r.push(tmp);
        }

        while(!r.empty()){
            s.push(r.pop());
        }
    }
}
