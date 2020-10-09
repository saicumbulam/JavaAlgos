package InterViewPrep;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    static List<List<String>> result = new ArrayList<>();


    public static void main(String[] args) {
        String str = "aab";
        Calculate(str, 0, new ArrayList<>());
        System.out.println(result);
    }

    private static void Calculate(String str, int start, List<String> curr)
    {
        boolean[][] dp = new boolean[str.length()][str.length()];

        for (int i = 0; i < str.length(); i++) {
            dp[i][i] = true;
        }

        for (int i = str.length()-1; i >= 0; i--) {
            for (int j = i+1; j < str.length() ; j++) {
                if(str.charAt(i) == str.charAt(j))
                {
                    if( j-i == 1 || dp[i+1][j-1])
                    {
                        dp[i][j] = true;
                    }
                }
            }
        }

        find(dp, 0, str, new ArrayList<>());

    }

    private static void find(boolean[][] dp, int startIdx, String str, List<String> curr){
        if(startIdx==str.length()){
            result.add(new ArrayList(curr));
            return;
        }
        for(int i=startIdx; i < str.length(); i++){
            if(dp[startIdx][i]){
                curr.add(str.substring(startIdx, i+1));
                find(dp, i+1, str, curr);
                curr.remove(curr.size()-1);
            }
        }
    }
}
