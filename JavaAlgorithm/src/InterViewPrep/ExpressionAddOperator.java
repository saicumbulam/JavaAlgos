package InterViewPrep;

import java.util.LinkedList;
import java.util.List;

public class ExpressionAddOperator {
    public static void main(String[] args) {
        System.out.println(Calculate("123", 6));
    }

    public static List<String> Calculate(String num, int target) {
        List<String> result = new LinkedList<>();
        dfs(result, num, "", 0, 0, 0, target);
        return result;
    }
    private static void dfs(List<String> result, String num,
                            String currResult, int startIdx, long sum, long last, int target){
        // If position meets the end and sum meets the target, we can add the value into the list.
        if(startIdx == num.length() && sum == target)
            result.add(currResult);

        for(int i = startIdx; i < num.length(); i++){
            if(i != startIdx && num.charAt(startIdx) == '0') break;

            long cur = Long.parseLong(num.substring(startIdx, i + 1));

            if(startIdx == 0){
                //Starts from begining, we just need to save the value.
                dfs(result, num, ""+cur, i + 1, cur, cur, target);
            }
            else{
                dfs(result, num, currResult + "+" + cur, i + 1, sum + cur, cur, target);
                // For next turn, current value is -cur, since we always use sum - last to get previous value.
                dfs(result, num, currResult + "-" + cur, i + 1, sum - cur, -cur, target);
                // multiplication is a little bit special,
                // we take the last * cur as cur, and sum need
                // to take the previous value terms as a term and
                // we need to minus the previous term and use the
                // previous term times current value and add to the sum.
                dfs(result, num, currResult + "*" + cur, i + 1,
                        sum - last + last * cur, last * cur, target);
            }
        }
    }
}
