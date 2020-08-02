package Leetcode.Misc.Medium;

public class FindCelebrity {
    public static void main(String[] args) {
        int numPeople = 3;
        int celebrityCandidate = 0;

        for (int i = 0; i < numPeople; i++) {
            if(knows(celebrityCandidate, i))
            {
                celebrityCandidate = i;
            }
        }

        if (isCelebrity(celebrityCandidate))
        {
            System.out.println(celebrityCandidate);
        }
    }

    private static boolean isCelebrity(int i) {
        int numPeople = 3;
        for (int j = 0; j < numPeople; j++) {
            if(i == j)
            {
                continue;
            }

            if(knows(i,j) && !knows(j,i))
            {
                return false;
            }
        }
        return true;
    }

    private static boolean knows(int celebrityCandidate, int i) {
        return true;
    }
}
