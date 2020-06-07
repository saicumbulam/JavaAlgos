package Legacy.Algorithms.Array;

import java.util.List;

public class ReachEnd {
    private static boolean canReachEnd(List<Integer> maxAdvanceSteps){
        int farthestReachSoFar = 0, lastIndex = maxAdvanceSteps.size()-1;

        for (int i = 0; i <=farthestReachSoFar && farthestReachSoFar < lastIndex ; i++) {
            farthestReachSoFar = Math.max(farthestReachSoFar, i + maxAdvanceSteps.get(i));
        }
        return farthestReachSoFar >= lastIndex;
    }
}
